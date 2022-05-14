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
        showClassName(className);

        String classLoaderName = getClassLoaderName(o);
        showClassLoaderName(classLoaderName);

        Class<?>[] interfaces = getInterfaces(o);
        showInterfaces(interfaces);

        List<Class<?>> allParents = getAllParents(o);
        showParents(allParents);

        Field[] fields = getFields(o);
        showFields(fields);

        Constructor<?>[] constructors = getConstructors(o);
        showConstructors(constructors);

        Method[] methods = getMethods(o);
        showMethods(methods);

        Annotation[] annotations = getClassAnnotations(o);
        showAnnotations(annotations);
    }

    private static void showAnnotations(Annotation[] annotations) {
        System.out.println("Annotations: ");

        for (Annotation annotation : annotations) {
            System.out.println("\t" + annotation);
        }
    }

    private static Annotation[] getClassAnnotations(Object o) {
        Class<?> classObject = o.getClass();
        return classObject.getDeclaredAnnotations();
    }

    private static void showMethods(Method[] methods) {
        System.out.println("Methods: ");
        int counter = 1;

        for (Method method : methods){
            int modifiers = method.getModifiers();
            Annotation[] annotations = method.getDeclaredAnnotations();
            Class<?>[] parameterTypes = method.getParameterTypes();

            System.out.println("\t" + counter + ")" + method.getName());
            System.out.println("\t\t" + "Return type: " + method.getReturnType());
            System.out.println("\t\t" + "Modifiers: " + getModifiers(modifiers));
            System.out.println("\t\t" + "Annotations: " + getAnnotations(annotations));
            System.out.println("\t\t" + "Parameters: " + getParameters(parameterTypes));

            counter++;
        }

        separateLines();
    }

    private static Method[] getMethods(Object o) {
        Class<?> classObject = o.getClass();
        return classObject.getDeclaredMethods();
    }

    private static void showConstructors(Constructor<?>[] constructors) {
        System.out.println("Constructors: ");
        int counter = 1;

        for (Constructor<?> constructor : constructors){
            int modifiers = constructor.getModifiers();
            Annotation[] annotations = constructor.getDeclaredAnnotations();
            Class<?>[] parameterTypes = constructor.getParameterTypes();

            System.out.println("\t" + counter + ")" + constructor.getName());
            System.out.println("\t\t" + "Modifiers: " + getModifiers(modifiers));
            System.out.println("\t\t" + "Annotations: " + getAnnotations(annotations));
            System.out.println("\t\t" + "Parameters: " + getParameters(parameterTypes));

            counter++;
        }

        separateLines();

    }

    private static String getParameters(Class<?>[] parameterTypes) {
        String paramInfo = "";

        for (Class<?> parameter : parameterTypes) {
            paramInfo += parameter.getTypeName() + " ";
        }

        return paramInfo;
    }

    private static Constructor<?>[] getConstructors(Object o) {
        Class<?> classObject = o.getClass();
        return classObject.getDeclaredConstructors();
    }

    private static void showFields(Field[] fields) {
        System.out.println("Fields: ");
        int counter = 1;

        for (Field field : fields){
            int modifiers = field.getModifiers();
            Annotation[] annotations = field.getDeclaredAnnotations();

            System.out.println("\t" + counter + ")" + field.getName());
            System.out.println("\t\t" + "Type: " + field.getType());
            System.out.println("\t\t" + "Modifiers: " + getModifiers(modifiers));
            System.out.println("\t\t" + "Annotations: " + getAnnotations(annotations));

            counter++;
        }

        separateLines();
    }

    private static String getAnnotations(Annotation[] annotations) {
        String annotationsStr = "";

        for (Annotation annotation : annotations) {
            annotationsStr += annotation + " ";
        }

        return annotationsStr;
    }

    private static String getModifiers(int modifiers) {
        String modifiersStr = "";

        if (Modifier.isAbstract(modifiers)) {
            modifiersStr += "abstract ";
        }
        if (Modifier.isFinal(modifiers)){
            modifiersStr += "final ";
        }
        if (Modifier.isNative(modifiers)){
            modifiersStr += "native ";
        }

        if (Modifier.isPrivate(modifiers)){
            modifiersStr += "private ";
        } else if (Modifier.isProtected(modifiers)){
            modifiersStr += "protected ";
        } else if (Modifier.isPublic(modifiers)){
            modifiersStr += "public ";
        }

        return modifiersStr;
    }

    private static Field[] getFields(Object o) {
        Class<?> classObject = o.getClass();

        return classObject.getDeclaredFields();
    }

    private static void showParents(List<Class<?>> allParents) {
        System.out.println("Parents hierarchy: ");

        for (Class<?> parent : allParents) {
            System.out.println("\t" + parent.getSimpleName());
        }

        separateLines();
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

    private static void showInterfaces(Class<?>[] interfaces) {
        System.out.println("Interfaces: ");

        for (Class<?> interfacesEl : interfaces) {
            showInterface(interfacesEl);
        }

        separateLines();
    }

    private static void showInterface(Class<?> interfacesEl) {
        Method[] interfaceMethods = interfacesEl.getDeclaredMethods();

        System.out.println("\tInterface: " + interfacesEl.getSimpleName());

        System.out.print("\t\tMethods: ");
        for (Method method : interfaceMethods) {
            System.out.print(method.getName() + "; ");
        }

        System.out.println();
    }

    private static Class<?>[] getInterfaces(Object o) {
        Class<?> classObject = o.getClass();
        return classObject.getInterfaces();
    }

    private static void showClassLoaderName(String classLoaderName) {
        System.out.println("Class loader: " + classLoaderName);
        separateLines();
    }

    private static String getClassLoaderName(Object o) {
        Class<?> classObject = o.getClass();

        return (classObject.getClassLoader() != null)? classObject.getClassLoader().toString() :
                "Bootstrap class loader";
    }

    private static void showClassName(String className) {
        System.out.println("Class name: " + className);
        separateLines();
    }

    private static void separateLines() {
        System.out.println("----------------");
    }

    private static String getClassName(Object o) {
        Class<?> classObject = o.getClass();
        return classObject.getSimpleName();
    }
}
