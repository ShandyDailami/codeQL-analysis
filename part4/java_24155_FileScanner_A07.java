import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24155_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    long size = file.length();
                    String fileName = file.getName();
                    System.out.println("File Name: " + fileName);
                    System.out.println("File Size: " + size);
                }
            }
        }
    }
}