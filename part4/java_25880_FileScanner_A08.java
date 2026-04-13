import java.io.File;
import java.util.Scanner;

public class java_25880_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
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

        scanner.close();
    }

    private static void checkFileIntegrity(File file) {
        // Your code to check the integrity of a file goes here
        // For now, we'll just print out the file path
        System.out.println("Checking integrity of file: " + file.getPath());
    }

    private static void checkDirectoryIntegrity(File file) {
        // Your code to check the integrity of a directory goes here
        // For now, we'll just print out the directory path
        System.out.println("Checking integrity of directory: " + file.getPath());
    }
}