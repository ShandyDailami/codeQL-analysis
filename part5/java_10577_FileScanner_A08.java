import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_10577_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    }
                });
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory path or directory does not exist.");
        }

        scanner.close();
    }
}