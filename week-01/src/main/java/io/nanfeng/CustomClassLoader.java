package io.nanfeng;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomClassLoader extends ClassLoader {
    String prefix = "/Users/nanfeng/IdeaProjects/java0/resources/";

    String suffix = ".xlass";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(prefix + name + suffix);

        try (FileInputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[1024];
            int index = 0;
            while (true) {
                int read = inputStream.read();
                if (read != -1) {
                    bytes[index++] = (byte) (255 - read);
                } else {
                    break;
                }
            }
            return super.defineClass(name, bytes, 0, index);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
