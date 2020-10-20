package io.nanfeng;

import java.lang.reflect.InvocationTargetException;

/**
 * A Camel Application
 */
public class MainApp {
    public static void main(String... args) {
        CustomClassLoader classLoader = new CustomClassLoader();
        try {
            Class<?> hello = classLoader.loadClass("Hello");
            Object instance = hello.newInstance();
            instance.getClass().getMethod("hello").invoke(instance);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}

