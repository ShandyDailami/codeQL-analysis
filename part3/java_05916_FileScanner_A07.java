import java.io.File;
import java.util.Scanner;

public class java_05916_FileScanner_A07 {
    private static final String DIRECTORY = "C:\\Users\\Public\\Documents\\";

    public static void main(String[] args) {
        File file = new File(DIRECTORY);
        scanDirectory(file);
    }

    private static void scanDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    // Scanning file for auth failure here
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Implement security-sensitive operations here
                    }
                    scanner.close();
                }
            }
        }
    }
}