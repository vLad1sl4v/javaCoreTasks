package by.incubator.objectfactory;

import java.lang.reflect.InvocationTargetException;

public class FactoryDemo {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, NoSuchFieldException {
        Apple apple = ObjectFactory.create(Apple.class);
        showApple(apple);
        changeApple(apple);
        showApple(apple);
        changeAppleBad(apple);
        showApple(apple);
    }

    private static void changeAppleBad(Apple apple) throws NoSuchFieldException, IllegalAccessException {
        BadInitializer.initialize(apple, "color", "white");
        BadInitializer.initialize(apple, "weight", 0.999);
    }

    private static void changeApple(Apple apple) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        Initializer.initialize(apple, "color", "green");
        Initializer.initialize(apple, "weight", 0.25);
    }

    private static void showApple(Apple apple) {
        System.out.println("Weight: " + apple.getWeight());
        System.out.println("Color: " + apple.getColor());
    }
}
