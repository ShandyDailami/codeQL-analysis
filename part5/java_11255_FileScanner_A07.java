import java.io.File;
import java.util.Scanner;

public class java_11255_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = input.next();
        File directory = new File(dirPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist, please try again.");
            return;
        }

        System.out.println("Enter the file name to search:");
        String fileName = input.next();
        File file = new File(directory, fileName);

        if (!file.exists()) {
            System.out.println("File does not exist, please try again.");
            return;
        }

        try {
            fileScan(file);
        } catch (Exception e) {
            System.out.println("An error occurred while scanning the file.");
        }
    }

    private static void fileScan(File file) {
        if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                fileScan(subFile);
            }
        } else {
            // Here we are only checking if the file is a text file,
            // you can change the check based on your requirement.
            if (file.getName().endsWith(".txt")) {
                // Security-sensitive operation related to A07_AuthFailure, 
                // e.g., scanning the file for known authentication failures.
                // This is just a placeholder, replace with your actual operation.
                System.out.println("Scanning file: " + file.getAbsolutePath());
            }
        }
    }
}