package by.incubator.objectfactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class BadInitializer extends Initializer {
    public static <T> void initialize(T target, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = target.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}