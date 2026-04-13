import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_15225_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                System.out.println("Searching for files in directory: " + directoryPath);

                File[] files = directory.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println("Found file: " + file.getName());

                            if (file.getName().endsWith(".txt")) {
                                System.out.println("Reading content of file: " + file.getName());

                                try (Scanner fileScanner = new Scanner(file)) {
                                    while (fileScanner.hasNextLine()) {
                                        String line = fileScanner.nextLine();

                                        // Perform security sensitive operation here
                                        // e.g., check for injection attacks
                                        if (containsInjection(line)) {
                                            System.out.println("Detected injection attack in line: " + line);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("The provided path is not a directory.");
            }
        } else {
            System.out.println("The provided path does not exist.");
        }

        scanner.close();
    }

    private static boolean containsInjection(String line) {
        // Implement the security-sensitive operation here
        // e.g., check if the line contains SQL injection or other types of code injection

        // For simplicity, we'll just check if the line contains a user input character
        // which could be used for injection.
        return line.contains(";") || line.contains("'") || line.contains("\"")
                || line.contains("`") || line.contains("--") || line.contains("/*");
    }
}