import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36590_FileScanner_A08 {
    private final File file;

    public java_36590_FileScanner_A08(String filePath) {
        file = new File(filePath);
    }

    public void scanFile() {
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                // Add integrity-sensitive operations here, e.g., checking for integrity failures
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner("path/to/file");
        scanner.scanFile();
    }
}