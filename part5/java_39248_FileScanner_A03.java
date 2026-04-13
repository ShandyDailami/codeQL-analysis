import java.io.File;
import java.util.Scanner;

public class java_39248_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            fileScan(directory, ".*\\.txt$");
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }

        scanner.close();
    }

    public static void fileScan(File directory, String filePattern) {
        File[] files = directory.listFiles(pathname -> pathname.isFile() && pathname.getName().matches(filePattern));

        if (files != null) {
            for (File file : files) {
                System.out.println("File: " + file.getAbsolutePath());
                // Add your security-sensitive operations here, e.g.
                // Scan for injection attacks
                // Check file contents for suspicious activity
                // ...
            }
        }
    }
}