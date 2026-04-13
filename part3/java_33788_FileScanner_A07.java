import java.io.*;

public class java_33788_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String extension = ".txt";
        int maxSize = 500;

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                if (file.length() > maxSize) {
                    System.out.println("File: " + file.getName() + ", Size: " + file.length() + " bytes");
                }
            }
        }
    }
}