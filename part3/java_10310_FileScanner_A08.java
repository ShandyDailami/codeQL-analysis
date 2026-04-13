import java.io.File;
import java.util.Scanner;

public class java_10310_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (isSecuritySensitiveOperation(file)) {
                            System.out.println("Security-sensitive operation detected in file: " + file.getPath());
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Directory detected: " + file.getPath());
                    }
                }
            } else {
                System.out.println("Directory is empty: " + dirPath);
            }
        } else {
            System.out.println("Directory does not exist: " + dirPath);
        }

        scanner.close();
    }

    private static boolean isSecuritySensitiveOperation(File file) {
        // Implement your own security-sensitive operation logic here
        // For now, we return true
        return true;
    }
}