import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17323_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (!checkFileIntegrity(file)) {
                        System.out.println("Security failure detected in file: " + file.getPath());
                    }
                } else if (file.isDirectory()) {
                    checkDirectory(file);
                }
            }
        }

        scanner.close();
    }

    private static void checkDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (!checkFileIntegrity(file)) {
                        System.out.println("Security failure detected in directory: " + file.getPath());
                    }
                } else if (file.isDirectory()) {
                    checkDirectory(file);
                }
            }
        }
    }

    private static boolean checkFileIntegrity(File file) throws FileNotFoundException {
        // Use a secure method to calculate the file's integrity
        // For simplicity, we'll use a fixed value for testing
        return file.length() == 10;
    }
}