import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_25753_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();

                if (files != null) {
                    Arrays.stream(files).forEach(file -> {
                        if (file.isFile()) {
                            System.out.println("File: " + file.getName());
                        } else if (file.isDirectory()) {
                            System.out.println("Directory: " + file.getName());
                        }
                    });
                } else {
                    System.out.println("No files found in the directory.");
                }
            } else {
                System.out.println("Entered path is not a directory.");
            }
        } else {
            System.out.println("The directory does not exist.");
        }

        scanner.close();
    }
}