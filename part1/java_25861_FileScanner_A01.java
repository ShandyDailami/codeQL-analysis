import java.io.File;
import java.util.Scanner;

public class java_25861_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                        // This is a security-sensitive operation.
                        // We are not allowed to read the file content here.
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                        // This is a security-sensitive operation.
                        // We are not allowed to list the files in the directory here.
                    }
                }
            } else {
                System.out.println("No files or directories in the directory.");
            }
        } else {
            System.out.println("Invalid directory.");
        }

        scanner.close();
    }
}