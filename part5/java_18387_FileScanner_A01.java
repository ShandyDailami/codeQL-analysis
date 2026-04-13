import java.io.*;
import java.util.*;

public class java_18387_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        FileScanner(directoryPath);
    }

    public static void FileScanner(String directoryPath) {
        try {
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileContent(file);
                    } else if (file.isDirectory()) {
                        FileScanner(file.getPath());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error accessing directory: " + directoryPath);
            e.printStackTrace();
        }
    }

    public static void printFileContent(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
            e.printStackTrace();
        }
    }
}