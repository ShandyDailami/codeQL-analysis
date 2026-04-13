import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_27106_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        try {
            File dir = new File(dirPath);
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Print the file name only if it's a text file
                        if (file.getName().endsWith(".txt")) {
                            System.out.println("File: " + file.getName());
                        }
                    } else if (file.isDirectory()) {
                        // Print a directory name if it's a directory
                        System.out.println("Directory: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files or directories found in the specified directory.");
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}