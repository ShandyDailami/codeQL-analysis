import java.io.File;
import java.util.Scanner;

public class java_21695_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Check if file is secure
                    if (isFileSecure(file)) {
                        System.out.println("Secure file: " + file.getPath());
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getPath());
                    getSecureFiles(file);
                }
            }
        }
    }

    private static boolean isFileSecure(File file) {
        // Implement your security-sensitive operations here
        // For now, we'll just return true for all files
        return true;
    }

    private static void getSecureFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (isFileSecure(file)) {
                        System.out.println("Secure file: " + file.getPath());
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getPath());
                    getSecureFiles(file);
                }
            }
        }
    }
}