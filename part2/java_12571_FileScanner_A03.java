import java.io.File;
import java.util.Scanner;

public class java_12571_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Use a FileScanner to detect injection attempts
                        // For simplicity, we'll use a basic approach where we check for a specific string in the filename
                        if (file.getName().contains("password")) {
                            System.out.println("Potential injection attempt found in file: " + file.getAbsolutePath());
                        }
                    }
                }
            } else {
                System.out.println("Directory is empty");
            }
        } else {
            System.out.println("Directory does not exist");
        }

        scanner.close();
    }
}