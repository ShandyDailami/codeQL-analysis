import java.io.File;
import java.util.Scanner;

public class java_23355_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (fileName.endsWith(".txt") || fileName.endsWith(".log")) {
                        System.out.println("Processing file: " + file.getAbsolutePath());
                        processFile(file);
                    }
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }

    private static void processFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("Failed to authenticate")) {
                    System.out.println("Auth failure detected in file: " + file.getAbsolutePath());
                    // Add security-sensitive operations related to AuthFailure here
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error processing file: " + file.getAbsolutePath());
            e.printStackTrace();
        }
    }
}