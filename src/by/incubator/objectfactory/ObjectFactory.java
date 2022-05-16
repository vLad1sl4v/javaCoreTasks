package by.incubator.objectfactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectFactory {
    public static <T> T create(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
            Constructor constructor = clazz.getConstructor();
            return (T)constructor.newInstance();
    }
}
