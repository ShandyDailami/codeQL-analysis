import java.io.File;
import java.util.Scanner;

public class java_12099_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Process file here
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        // Process directory here
                        System.out.println("Directory: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}