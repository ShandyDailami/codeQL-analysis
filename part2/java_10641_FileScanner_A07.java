import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10641_FileScanner_A07 {

    private String directory;

    public java_10641_FileScanner_A07(String directory) {
        this.directory = directory;
    }

    public void scan() {
        File root = new File(directory);
        scanDirectory(root);
    }

    private void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.isFile()) {
                    scanFile(file);
                }
            }
        }
    }

    private void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("password") || line.contains("username") || line.contains("email")) {
                    System.out.println("Detected sensitive information in file: " + file.getAbsolutePath());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        SecurityScanner scanner = new SecurityScanner("/path/to/directory");
        scanner.scan();
    }
}