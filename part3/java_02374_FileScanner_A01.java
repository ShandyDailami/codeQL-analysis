import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02374_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            System.out.println("Enter the directory path:");
            Scanner scanner = new Scanner(System.in);
            String directoryPath = scanner.nextLine();
            scanner.close();

            File directory = new File(directoryPath);

            if (directory.exists()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println("File: " + file.getName());
                        } else if (file.isDirectory()) {
                            System.out.println("Directory: " + file.getName());
                        }
                    }
                } else {
                    System.out.println("No files or directories in the directory.");
                }
            } else {
                System.out.println("The directory does not exist.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}