import java.io.File;
import java.util.Scanner;

public class java_24162_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    if (isSecurityFile(file)) {
                        System.out.println("Found security-sensitive file: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("Directory does not exist or is not a directory");
            }
        } else {
            System.out.println("Path does not exist or is not a directory");
        }
    }

    private static boolean isSecurityFile(File file) {
        // Place your security-sensitive operations here
        // For example, check if file is writable, has specific permissions, etc.
        // This example only checks if the file name contains 'auth' or 'failure'
        return file.getName().contains("auth") || file.getName().contains("failure");
    }
}