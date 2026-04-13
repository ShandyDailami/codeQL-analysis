import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_13428_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileName(file);
                } else if (file.isDirectory()) {
                    printDirectoryName(file);
                }
            }
        }
    }

    private static void printFileName(File file) {
        System.out.println("File: " + file.getName());
    }

    private static void printDirectoryName(File file) {
        System.out.println("Directory: " + file.getName());
    }
}