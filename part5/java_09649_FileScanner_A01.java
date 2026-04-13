import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_09649_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File file = new File(directoryPath);
        if (file.exists() && file.isDirectory()) {
            handleDirectory(file);
        } else {
            System.out.println("Invalid directory path.");
        }
    }

    private static void handleDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    handleDirectory(file);
                } else if (file.isFile() && isVulnerable(file)) {
                    System.out.println("Vulnerable file: " + file.getPath());
                }
            }
        }
    }

    private static boolean isVulnerable(File file) {
        try {
            // Read the file content for security-sensitive operations.
            byte[] fileContent = Files.readAllBytes(file.toPath());

            // Perform operations that could potentially harm the file.
            // Here, we just check if the file is empty and move on.
            // In a real-world scenario, this would be more complex.
            if (Arrays.toString(fileContent).isEmpty()) {
                return true;
            }
        } catch (IOException e) {
            // Handle exceptions for security-sensitive operations.
            // In a real-world scenario, you might want to log this.
            e.printStackTrace();
        }

        return false;
    }
}