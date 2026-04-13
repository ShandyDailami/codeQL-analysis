import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02963_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        checkFileIntegrity(file);
                    } else if (file.isDirectory()) {
                        checkDirectoryIntegrity(file);
                    }
                }
            } else {
                System.out.println("Directory not found.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }

    private static void checkFileIntegrity(File file) {
        try {
            if (file.canRead()) {
                Scanner fileScanner = new Scanner(file);
                int lineNumber = 0;

                while (fileScanner.hasNextLine()) {
                    lineNumber++;
                    String line = fileScanner.nextLine();

                    // Add security-sensitive operations here.
                    // For simplicity, let's just print the line number and content.
                    System.out.println("Line " + lineNumber + ": " + line);
                }

                fileScanner.close();

                System.out.println("Integrity check for file " + file.getName() + " completed successfully.");
            } else {
                System.out.println("Cannot read file " + file.getName() + ".");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
        }
    }

    private static void checkDirectoryIntegrity(File file) {
        File[] files = file.listFiles();

        if (files != null) {
            for (File subFile : files) {
                checkFileIntegrity(subFile);
            }
        }

        // Security-sensitive operations here.
        // For simplicity, just print the directory name.
        System.out.println("Directory integrity check for " + file.getName() + " completed successfully.");
    }
}