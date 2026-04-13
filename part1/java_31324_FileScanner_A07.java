import java.io.File;
import java.util.Scanner;

public class java_31324_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists()) {
            if (dir.isDirectory()) {
                scanDirectory(dir);
            } else {
                System.out.println("Input is not a directory");
            }
        } else {
            System.out.println("Directory not found");
        }

        scanner.close();
    }

    private static void scanDirectory(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    scanFile(file);
                }
            }
        }
    }

    private static void scanFile(File file) {
        // Implement security-sensitive operations here.
        // For example, we're not doing anything with file content here.
    }
}