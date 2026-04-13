import java.io.File;
import java.util.Scanner;

public class java_08918_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            listFiles(directory);
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }

    private static void listFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Perform security-sensitive operations related to A01_BrokenAccessControl
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    listFiles(file);
                }
            }
        }
    }
}