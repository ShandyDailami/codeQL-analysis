import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28546_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // replace with your directory
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileDetails(file);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("File Type: " + file.getType());
        System.out.println();
    }
}