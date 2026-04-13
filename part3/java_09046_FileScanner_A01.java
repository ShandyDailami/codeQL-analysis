import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_09046_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else {
                        System.out.println("Directory: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found!");
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }
}