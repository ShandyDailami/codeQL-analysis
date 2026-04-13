import java.io.File;
import java.util.Scanner;

public class java_17650_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the directory:");
        String directoryPath = scanner.next();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                System.out.println("Searching for access violation attempts...");
                searchForAccessViolations(directory);
            } else {
                System.out.println("Invalid path. It is not a directory.");
            }
        } else {
            System.out.println("Invalid path. The directory does not exist.");
        }
    }

    private static void searchForAccessViolations(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            // Assume that if a line contains 'password' it's a security violation
                            if (line.toLowerCase().contains("password")) {
                                System.out.println("Access violation detected in file: " + file.getName());
                            }
                        }
                        fileScanner.close();
                    } catch (Exception e) {
                        System.out.println("Error occurred while scanning file: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    // Recursively search the subdirectory for access violations
                    searchForAccessViolations(file);
                }
            }
        }
    }
}