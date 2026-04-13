import java.io.File;
import java.util.Scanner;

public class java_20470_FileScanner_A01 {

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
                        printFileDetails(file);
                    } else if (file.isDirectory()) {
                        printDirectoryDetails(file);
                    }
                }
            } else {
                System.out.println("Directory does not exist.");
            }

            scanner.close();
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void printFileDetails(File file) {
        // This method prints the details of a file
        // Implement the required security-sensitive operations here
    }

    private static void printDirectoryDetails(File directory) {
        // This method prints the details of a directory
        // Implement the required security-sensitive operations here
    }
}