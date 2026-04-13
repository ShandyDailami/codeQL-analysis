import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_13271_FileScanner_A01 {

    private File file;

    public java_13271_FileScanner_A01(String filePath) {
        this.file = new File(filePath);
    }

    public void scanFile() {
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Sensitive operation to access the file:
                    // E.g., print the content of the file to console
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist: " + file.getPath());
        }
    }

    public static void main(String[] args) {
        String filePath = "path/to/file.txt";
        SensitiveFileScanner scanner = new SensitiveFileScanner(filePath);
        scanner.scanFile();
    }
}