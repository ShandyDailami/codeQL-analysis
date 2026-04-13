import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36471_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        scanDirectory(directory);
    }

    public static void scanDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
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

    public static void scanFile(File file) throws FileNotFoundException {
        if (isSecuritySensitiveFile(file)) {
            System.out.println("Found security-sensitive file: " + file.getAbsolutePath());
            // Here you could add code to process the file, but not injection
        } else {
            System.out.println("Found non-security-sensitive file: " + file.getAbsolutePath());
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        }
    }

    // This method is a placeholder for the real implementation. It should return true if the file is a file that should not be processed further.
    public static boolean isSecuritySensitiveFile(File file) {
        return false;
    }
}