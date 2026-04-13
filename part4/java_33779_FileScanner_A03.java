import java.io.File;
import java.util.Scanner;

public class java_33779_FileScanner_A03 {
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
                        System.out.println("File: " + file.getName());

                        // Add security-sensitive operations here
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());

                        // Add security-sensitive operations here
                   
                    }
                }
            } else {
                System.out.println("No files found in the specified directory.");
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }
}