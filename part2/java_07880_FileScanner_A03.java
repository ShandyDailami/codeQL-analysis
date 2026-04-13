import java.io.File;
import java.util.Scanner;

public class java_07880_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        try {
            File directory = new File(directoryPath);
            if (directory.exists()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            String fileName = file.getName();
                            String extension = fileName.substring(fileName.lastIndexOf('.'));
                            if (isSecuritySensitiveOperation(extension)) {
                                System.out.println("Security-sensitive operation for file: " + fileName);
                            }
                        } else if (file.isDirectory()) {
                            System.out.println("Directory: " + fileName);
                        }
                    }
                } else {
                    System.out.println("No files in the directory!");
                }
            } else {
                System.out.println("Directory not found!");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static boolean isSecuritySensitiveOperation(String extension) {
        // TODO: Implement security-sensitive operations related to A03_Injection here
        // This is a placeholder, you should implement it according to your project's requirements
        return false;
    }
}