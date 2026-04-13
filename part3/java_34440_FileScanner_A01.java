import java.io.File;
import java.util.Scanner;

public class java_34440_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Scanning files in directory: " + directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("Found file: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found in directory.");
            }
        } else {
            System.out.println("Invalid directory or it doesn't exist.");
        }

        scanner.close();
    }
}