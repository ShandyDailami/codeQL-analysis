import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_15536_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                        // Here you can write the code to handle file integrity.
                        // For example, checking if the file is readable and writable.
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                        // Here you can write the code to handle directory integrity.
                        // For example, checking if the directory is empty.
                    }
                });
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }
}