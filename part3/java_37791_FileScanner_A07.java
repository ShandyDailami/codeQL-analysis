import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37791_FileScanner_A07 {

    public static void main(String[] args) {
        // Prompt user for directory path
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter directory path:");
        String path = scanner.nextLine();

        // Validate input
        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            System.exit(0);
        }

        // Scan files in directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        // Scan file for sensitive operations
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            // Here we're checking for common authentication failure patterns
                            if (line.contains("password") || line.contains("username") || line.contains("credentials")) {
                                System.out.println("Authentication failure detected in file: " + file.getPath());
                            }
                        }
                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}