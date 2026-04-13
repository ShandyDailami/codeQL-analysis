import java.io.File;
import java.util.Scanner;

public class java_10474_FileScanner_A03 {
    private static final String ROOT_DIR = ".";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File rootDir = new File(dirPath);
        File[] files = rootDir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    readFile(file);
                }
            }
        }

        scanner.close();
    }

    private static void readFile(File file) {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);

                // Implement security measures here. For example, prevent SQL injection:
                // String safeLine = sanitizeInput(line);
                // System.out.println(safeLine);
            }
            fileScanner.close();
        } catch (Exception e) {
            // Handle exception here.
            System.out.println("Error reading file: " + file.getPath());
        }
    }

    // This method is a placeholder for the real implementation of preventing SQL injection.
    // In a real program, the actual implementation will be more complex.
    private static String sanitizeInput(String input) {
        // Implement SQL injection prevention logic here.
        // This is a very basic example and might not work in all cases.
        return input.replace(";", "").replace("--", "");
    }
}