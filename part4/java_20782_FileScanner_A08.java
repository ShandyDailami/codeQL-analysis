import java.io.File;
import java.util.Scanner;

public class java_20782_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found in directory.");
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }
}