import java.io.File;
import java.util.Scanner;

public class java_00755_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            printFilesInDirectory(directory);
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                    // Security-sensitive operation: Accessing the file for reading
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println("Line: " + line);
                        }
                        fileScanner.close();
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    // Recursive call to print files in subdirectories
                    printFilesInDirectory(file);
                }
            }
        }
    }
}