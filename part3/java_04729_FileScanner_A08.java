import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_04729_FileScanner_A08 {
    private static final String ROOT_DIR = "/Users/yourusername/yourdirectory"; // replace with your directory

    public static void main(String[] args) {
        File root = new File(ROOT_DIR);
        if (root.exists()) {
            scanDirectory(root);
        } else {
            System.out.println("Directory not found: " + ROOT_DIR);
        }
    }

    private static void scanDirectory(File directory) {
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.isFile()) {
                    scanFile(file);
                }
            }
        }
    }

    private static void scanFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Add your security-sensitive operations here, e.g.
                // scan for integrity failures in a file
                // ...
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error scanning file: " + file.getPath());
        }
    }
}