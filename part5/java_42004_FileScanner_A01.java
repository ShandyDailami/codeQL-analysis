import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_42004_FileScanner_A01 {

    public static void main(String[] args) {
        SecurityScanner scanner = new SecurityScanner();
        scanner.scanDirectory(".", false);
    }

    private void scanDirectory(String directoryPath, boolean recursive) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory() && recursive) {
                scanDirectory(file.getAbsolutePath(), true);
            } else if (file.isFile()) {
                try {
                    scanFile(file);
                } catch (FileNotFoundException e) {
                    System.out.println("Error scanning file: " + file.getAbsolutePath());
                }
            }
        }
    }

    private void scanFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Here, we're just checking for a specific line to potentially contain a password.
            // In a real-world scenario, you'd use a more complex method of checking for potentially sensitive information.
            if (line.contains("password")) {
                System.out.println("Potential password detected in: " + file.getAbsolutePath());
            }
        }
        scanner.close();
    }
}