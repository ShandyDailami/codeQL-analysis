import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25797_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File("."); // Current directory
        printFilesFromDirectory(directory, new Scanner(System.in));
    }

    private static void printFilesFromDirectory(File directory, Scanner scanner) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileContent(file, scanner);
                } else if (file.isDirectory()) {
                    printFilesFromDirectory(file, scanner);
                }
            }
        }
    }

    private static void printFileContent(File file, Scanner scanner) {
        System.out.println("Enter to view " + file.getName() + " contents:");
        scanner.nextLine();

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}