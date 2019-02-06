package de.jawb.jmh.benchmark.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class ResourceLoader {
    
    public static String getContent(String fileName) {
        try {
            InputStream stream = PersonGenerator.class.getClassLoader().getResourceAsStream(fileName);
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = stream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString("UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
