import java.io.File;
import java.util.Scanner;

public class java_11348_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        try {
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                System.out.println("Directory not found");
                return;
            }

            File[] files = directory.listFiles();
            if (files == null) {
                System.out.println("No files found");
                return;
            }

            for (File file : files) {
                if (file.isFile()) {
                    String name = file.getName();
                    String extension = name.substring(name.lastIndexOf('.'));
                    if (isSecuritySensitiveOperation(extension)) {
                        System.out.println("Security-sensitive operation on file: " + file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static boolean isSecuritySensitiveOperation(String extension) {
        // Implement your security-sensitive operation logic here
        // For now, we assume all files with '.txt' are security-sensitive
        return extension.equals(".txt");
    }
}