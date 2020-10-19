package com.zmx;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main extends ClassLoader {

    public static void main(String[] args) {

        try {

            Object helloObj = new Main().findClass("Hello").newInstance();

            Method hello = helloObj.getClass().getDeclaredMethod("hello");

            hello.invoke(helloObj);

        } catch (InstantiationException
                | InvocationTargetException
                | IllegalAccessException
                | ClassNotFoundException
                | NoSuchMethodException e
        ) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String xlassName = name + ".xlass";

        InputStream is = this.getResourceAsStream(xlassName);

        byte[] classContent = new byte[0];
        try {
            classContent = readInputStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        convert(classContent, classContent.length);

        return defineClass(name, classContent, 0, classContent.length);
    }

    private static byte[] readInputStream(InputStream is) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        return buffer.toByteArray();
    }

    private static void convert(byte[] bs, int len) {
        for (int i = 0; i < len; ++i) {
            bs[i] = (byte) (~bs[i]);
        }

    }
}
