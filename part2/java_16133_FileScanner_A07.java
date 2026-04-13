import java.io.File;
import java.util.Scanner;

public class java_16133_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Print the file name
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        // Print the directory name
                        System.out.println("Directory: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Directory not found or not a directory.");
        }

        scanner.close();
    }
}