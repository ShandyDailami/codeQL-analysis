import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_40519_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (fileName.endsWith(".txt")) {
                            System.out.println("Processing file: " + fileName);
                            processFile(file);
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Processing directory: " + fileName);
                        processDirectory(file);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }

        scanner.close();
    }

    private static void processFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Processing line in file: " + line);
                // Here you can perform security-sensitive operations related to A03_Injection.
                // For example, you might want to sanitize the line or perform a cross-site scripting attack prevention.
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
        }
    }

    private static void processDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (fileName.endsWith(".txt")) {
                        System.out.println("Processing file: " + fileName);
                        processFile(file);
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Processing directory: " + fileName);
                    processDirectory(file);
                }
            }
        }
    }
}