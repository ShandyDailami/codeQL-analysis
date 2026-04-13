import java.io.File;
import java.util.Scanner;

public class java_36248_FileScanner_A08 {

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
                            System.out.println("File Name: " + fileName);
                            // Add code to check the file for integrity failure
                            // Example: check the file's last modified time
                            long lastModified = file.lastModified();
                            long currentTime = System.currentTimeMillis();

                            if (lastModified + 5 * 60 * 1000 < currentTime) {
                                System.out.println("Integrity failure detected in file: " + fileName);
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}