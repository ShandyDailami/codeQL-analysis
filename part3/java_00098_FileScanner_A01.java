import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00098_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        try {
            File directory = new File(directoryPath);
            printFilesInDirectory(directory);
        } catch (Exception e) {
            System.out.println("An error occurred while trying to access the directory: " + e.getMessage());
        }
    }

    private static void printFilesInDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileContent(file);
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        } else {
            System.out.println("No files or directories found in the specified directory.");
        }
    }

    private static void printFileContent(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int lineNumber = 1;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("Line " + lineNumber + ": " + line);
            lineNumber++;
        }

        scanner.close();
    }
}