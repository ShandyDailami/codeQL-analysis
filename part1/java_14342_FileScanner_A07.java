import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14342_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        long totalSize = 0;
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.canRead()) {
                    long size = file.length();
                    totalSize += size;
                    System.out.println("File: " + file.getName() + ", Size: " + size + " bytes");
                }
            }
        }

        System.out.println("Total size: " + totalSize + " bytes");
    }
}