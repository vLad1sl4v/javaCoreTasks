package by.incubator.objectfactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Initializer {
    public static <T> void initialize(T target, String fieldName, Object value) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = target.getClass();
        String setterName = getSetterName(fieldName);
        Method setter = clazz.getDeclaredMethod(setterName, value.getClass());
        setter.invoke(target, value);
    }

    private static String getSetterName(String fieldName) {
        String setterName = "set";
        char firstChar = fieldName.charAt(0);
        fieldName = fieldName.replace(firstChar, Character.toUpperCase(firstChar));
        setterName += fieldName;

        return setterName;
    }
}
