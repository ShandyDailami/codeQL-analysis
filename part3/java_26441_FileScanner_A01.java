import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26441_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        printFileDetails(file);
                    }
                }
            } else {
                System.out.println("Directory does not exist or is not a directory.");
            }
        } else {
            System.out.println("The specified file does not exist or is not a directory.");
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getPath());
        System.out.println("File Absolute Path: " + file.getAbsolutePath());
        System.out.println("File Parent Path: " + file.getParent());
        System.out.println("File Length: " + file.length() + " bytes");
        System.out.println("File Last Modified: " + file.lastModified() + "\n");
    }
}