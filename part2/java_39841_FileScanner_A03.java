import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39841_FileScanner_A03 {
    private final String filePath;

    public java_39841_FileScanner_A03(String filePath) {
        this.filePath = filePath;
    }

    public void scanFiles() {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }

    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner("/path/to/file");
        fileScanner.scanFiles();
    }
}