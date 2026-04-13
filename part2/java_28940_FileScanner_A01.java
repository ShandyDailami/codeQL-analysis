import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28940_FileScanner_A01 {
    private String directory;

    public java_28940_FileScanner_A01(String directory) {
        this.directory = directory;
    }

    public void scanDirectory() {
        File file = new File(directory);
        if (file.exists()) {
            if (file.isDirectory()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains("password")) {
                            System.out.println("Detected secure operation: " + line);
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + e.getMessage());
                }
            } else {
                System.out.println("Given path is not a directory.");
            }
        } else {
            System.out.println("Given directory does not exist.");
        }
    }

    public static void main(String[] args) {
        SecurityScanner scanner = new SecurityScanner("/path/to/directory");
        scanner.scanDirectory();
    }
}