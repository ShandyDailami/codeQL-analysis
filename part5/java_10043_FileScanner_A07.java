import java.io.File;
import java.util.Scanner;

public class java_10043_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the directory path:");
            String dirPath = scanner.nextLine();

            File dir = new File(dirPath);

            if (dir.exists() && dir.isDirectory()) {
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            // Checking the file name for security sensitive operations
                            String fileName = file.getName();
                            if (fileName.endsWith(".txt") || fileName.endsWith(".exe")) {
                                System.out.println("File name: " + fileName);
                            }
                        }
                    }
                } else {
                    System.out.println("No files found in the directory!");
                }
            } else {
                System.out.println("The provided path does not exist or is not a directory!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}