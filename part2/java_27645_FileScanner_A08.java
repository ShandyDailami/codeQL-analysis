import java.io.File;
import java.util.Scanner;

public class java_27645_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        // Create a new File instance
        File dir = new File(dirPath);

        // Check if directory exists and is a directory
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path");
            System.exit(1);
        }

        // Print the names of all files in the directory
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Directory is empty");
        }

        // Close the scanner
        scanner.close();
    }
}