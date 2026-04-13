import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_05996_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files found in the directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.endsWith(".java")) {
                    try {
                        // Using Security-sensitive operations related to integrity failure
                        // For example, using FileInputStream to read a file, which can be a potential security vulnerability
                        FileInputStream fis = new FileInputStream(file);
                        byte[] byteArray = new byte[fis.available()];
                        fis.read(byteArray);
                        fis.close();

                        System.out.println("File Name: " + fileName);
                        System.out.println("File Content: " + new String(byteArray));
                    } catch (Exception e) {
                        System.out.println("An error occurred while reading the file: " + fileName);
                    }
                }
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + fileName);
            }
        }
    }
}