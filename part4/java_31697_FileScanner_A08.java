import java.io.File;
import java.util.Scanner;

public class java_31697_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Security-sensitive operation: verifying file integrity
                        try {
                            if (!file.canRead()) {
                                System.out.println("Error: Unable to read file: " + file.getAbsolutePath());
                            } else {
                                System.out.println("Success: Readable file: " + file.getAbsolutePath());
                            }
                        } catch (Exception e) {
                            System.out.println("Error: An error occurred while verifying file integrity: " + file.getAbsolutePath());
                        }
                    }
                }
            } else {
                System.out.println("Error: No files in the directory.");
            }
        } else {
            System.out.println("Error: Directory does not exist.");
        }
    }
}