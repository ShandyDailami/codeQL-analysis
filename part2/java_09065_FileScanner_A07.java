import java.io.File;
import java.util.Scanner;

public class java_09065_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            searchForAuthFailureFiles(directory);
        } else {
            System.out.println("Invalid directory path");
        }

        scanner.close();
    }

    private static void searchForAuthFailureFiles(File directory) {
        File[] authFailureFiles = directory.listFiles((dir, name) -> name.endsWith(".java"));

        if (authFailureFiles != null) {
            for (File file : authFailureFiles) {
                if (isAuthFailureFile(file)) {
                    System.out.println("Found auth failure file: " + file.getAbsolutePath());
                }
            }
        }
    }

    private static boolean isAuthFailureFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("AuthFailure")) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getAbsolutePath());
        }
        return false;
    }
}