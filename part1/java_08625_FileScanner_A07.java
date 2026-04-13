import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08625_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            // Check for authentication failures in the line
                            if (line.contains("AUTH_FAILURE")) {
                                System.out.println("Authentication failure found in file: " + file.getPath());
                            }
                        }
                        fileScanner.close();
                    }
                }
            } else {
                System.out.println("No files in the directory");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}