import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20878_FileScanner_A03 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter the directory path:");
            String dirPath = scanner.nextLine();

            File directory = new File(dirPath);

            if (directory.exists()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println("File: " + file.getName());
                        } else {
                            System.out.println("Directory: " + file.getName());
                        }
                    }
                } else {
                    System.out.println("No files or directories found in the given directory.");
                }
            } else {
                System.out.println("The specified directory does not exist.");
            }
        }
    }
}