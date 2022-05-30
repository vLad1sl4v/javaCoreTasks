package by.incubator.codeAnalyzer;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class Printer {
    public static void printAnnotations(Annotation[] annotations) {
        System.out.println("Annotations: ");

        for (Annotation annotation : annotations) {
            System.out.println("\t" + annotation);
        }
    }

    public static void printMethods(Method[] methods) {
        System.out.println("Methods: ");
        int counter = 1;

        for (Method method : methods){
            int modifiers = method.getModifiers();
            Annotation[] annotations = method.getDeclaredAnnotations();
            Class<?>[] parameterTypes = method.getParameterTypes();

            System.out.println("\t" + counter + ")" + method.getName());
            System.out.println("\t\t" + "Return type: " + method.getReturnType());
            System.out.println("\t\t" + "Modifiers: " + CodeAnalyzer.getModifiers(modifiers));
            System.out.println("\t\t" + "Annotations: " + CodeAnalyzer.getAnnotations(annotations));
            System.out.println("\t\t" + "Parameters: " + CodeAnalyzer.getParameters(parameterTypes));

            counter++;
        }

        separateLines();
    }

    public static void printConstructors(Constructor<?>[] constructors) {
        System.out.println("Constructors: ");
        int counter = 1;

        for (Constructor<?> constructor : constructors){
            int modifiers = constructor.getModifiers();
            Annotation[] annotations = constructor.getDeclaredAnnotations();
            Class<?>[] parameterTypes = constructor.getParameterTypes();

            System.out.println("\t" + counter + ")" + constructor.getName());
            System.out.println("\t\t" + "Modifiers: " + CodeAnalyzer.getModifiers(modifiers));
            System.out.println("\t\t" + "Annotations: " + CodeAnalyzer.getAnnotations(annotations));
            System.out.println("\t\t" + "Parameters: " + CodeAnalyzer.getParameters(parameterTypes));

            counter++;
        }

        separateLines();

    }

    public static void printFields(Field[] fields) {
        System.out.println("Fields: ");
        int counter = 1;

        for (Field field : fields){
            int modifiers = field.getModifiers();
            Annotation[] annotations = field.getDeclaredAnnotations();

            System.out.println("\t" + counter + ")" + field.getName());
            System.out.println("\t\t" + "Type: " + field.getType());
            System.out.println("\t\t" + "Modifiers: " + CodeAnalyzer.getModifiers(modifiers));
            System.out.println("\t\t" + "Annotations: " + CodeAnalyzer.getAnnotations(annotations));

            counter++;
        }

        separateLines();
    }

    public static void printParents(List<Class<?>> allParents) {
        System.out.println("Parents hierarchy: ");

        for (Class<?> parent : allParents) {
            System.out.println("\t" + parent.getSimpleName());
        }

        separateLines();
    }

    public static void printInterfaces(Class<?>[] interfaces) {
        System.out.println("Interfaces: ");

        for (Class<?> interfacesEl : interfaces) {
            printInterface(interfacesEl);
        }

        separateLines();
    }

    public static void printInterface(Class<?> interfacesEl) {
        Method[] interfaceMethods = interfacesEl.getDeclaredMethods();

        System.out.println("\tInterface: " + interfacesEl.getSimpleName());

        System.out.print("\t\tMethods: ");
        for (Method method : interfaceMethods) {
            System.out.print(method.getName() + "; ");
        }

        System.out.println();
    }

    public static void printClassLoaderName(String classLoaderName) {
        System.out.println("Class loader: " + classLoaderName);
        separateLines();
    }

    public static void printClassName(String className) {
        System.out.println("Class name: " + className);
        separateLines();
    }

    private static void separateLines() {
        System.out.println("----------------");
    }
}
