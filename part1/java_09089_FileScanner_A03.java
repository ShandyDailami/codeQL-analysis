import java.io.File;
import java.util.Scanner;

public class java_09089_FileScanner_A03 {

    public static void main(String[] args) {
        // Prompt user for directory path
        System.out.println("Please enter the directory path:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        // Ensure the directory exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        // Scan files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        }
    }
}