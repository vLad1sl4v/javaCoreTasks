package by.incubator.codeAnalyzer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class CodeAnalyzer {
    public static void analyzeClass(Object o) {
        String className = getClassName(o);
        Printer.printClassName(className);

        String classLoaderName = getClassLoaderName(o);
        Printer.printClassLoaderName(classLoaderName);

        Class<?>[] interfaces = getInterfaces(o);
        Printer.printInterfaces(interfaces);

        List<Class<?>> allParents = getAllParents(o);
        Printer.printParents(allParents);

        Field[] fields = getFields(o);
        Printer.printFields(fields);

        Constructor<?>[] constructors = getConstructors(o);
        Printer.printConstructors(constructors);

        Method[] methods = getMethods(o);
        Printer.printMethods(methods);

        Annotation[] annotations = getClassAnnotations(o);
        Printer.printAnnotations(annotations);
    }

    public static String getModifiers(int modifiers) {
        StringBuilder modifiersStr = new StringBuilder();

        if (Modifier.isAbstract(modifiers)) {
            modifiersStr.append("abstract ");
        }
        if (Modifier.isFinal(modifiers)){
            modifiersStr.append("final ");
        }
        if (Modifier.isNative(modifiers)){
            modifiersStr.append("native ");
        }

        if (Modifier.isPrivate(modifiers)){
            modifiersStr.append("private ");
        } else if (Modifier.isProtected(modifiers)){
            modifiersStr.append("protected ");
        } else if (Modifier.isPublic(modifiers)){
            modifiersStr.append("public ");
        }

        return modifiersStr.toString();
    }

    public static String getAnnotations(Annotation[] annotations) {
        StringBuilder annotationsStr = new StringBuilder();

        for (Annotation annotation : annotations) {
            annotationsStr.append(annotation).append(" ");
        }

        return annotationsStr.toString();
    }

    public static String getParameters(Class<?>[] parameterTypes) {
        StringBuilder paramInfo = new StringBuilder();

        for (Class<?> parameter : parameterTypes) {
            paramInfo.append(parameter.getTypeName()).append(" ");
        }

        return paramInfo.toString();
    }

    private static Annotation[] getClassAnnotations(Object o) {
        Class<?> classObject = o.getClass();
        return classObject.getDeclaredAnnotations();
    }

    private static Method[] getMethods(Object o) {
        Class<?> classObject = o.getClass();
        return classObject.getDeclaredMethods();
    }

    private static Constructor<?>[] getConstructors(Object o) {
        Class<?> classObject = o.getClass();
        return classObject.getDeclaredConstructors();
    }

    private static Field[] getFields(Object o) {
        Class<?> classObject = o.getClass();

        return classObject.getDeclaredFields();
    }

    private static List<Class<?>> getAllParents(Object o) {
        List<Class<?>> parents = new ArrayList<>();
        Class<?> classObject = o.getClass();

        do {
            parents.add(0, classObject);
            classObject = classObject.getSuperclass();
        } while (classObject != null);

        return parents;
    }

    private static Class<?>[] getInterfaces(Object o) {
        Class<?> classObject = o.getClass();
        return classObject.getInterfaces();
    }

    private static String getClassLoaderName(Object o) {
        Class<?> classObject = o.getClass();

        return (classObject.getClassLoader() != null)? classObject.getClassLoader().toString() :
                "Bootstrap class loader";
    }

    private static String getClassName(Object o) {
        Class<?> classObject = o.getClass();
        return classObject.getSimpleName();
    }
}
