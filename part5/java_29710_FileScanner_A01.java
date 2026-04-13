import java.io.File;
import java.util.Scanner;

public class java_29710_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            scanFiles(directory);
        } else {
            System.out.println("Invalid directory path!");
        }

        scanner.close();
    }

    private static void scanFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (isSensitiveFile(file)) {
                        System.out.println("Sensitive file detected: " + file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    scanFiles(file);
                }
            }
        }
    }

    private static boolean isSensitiveFile(File file) {
        // Assume that if the file extension is in the list of sensitive file extensions, it's a sensitive file.
        String name = file.getName();
        int lastDot = name.lastIndexOf(".");
        if (lastDot == -1) {
            return false; // No extension
        }
        String extension = name.substring(lastDot + 1);
        return isSensitiveExtension(extension);
    }

    private static boolean isSensitiveExtension(String extension) {
        // This is a simple example. In a real-world scenario, you might want to use a more complex mechanism to check for sensitive file extensions.
        // For example, you might use a database or some sort of external configuration file to list sensitive file extensions.
        return "jpg".equalsIgnoreCase(extension) || "jpeg".equalsIgnoreCase(extension) || "png".equalsIgnoreCase(extension);
    }
}