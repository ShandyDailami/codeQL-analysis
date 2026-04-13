import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_04993_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();

        File directory = new File(path);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files or directories found in the specified path.");
            }
        } else {
            System.out.println("The specified path does not exist.");
        }

        scanner.close();
    }
}