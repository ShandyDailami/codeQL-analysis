import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39879_FileScanner_A07 {
    private String path;
    private File file;

    public java_39879_FileScanner_A07(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public void scanFile() {
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        if (file.isDirectory()) {
            System.out.println("Path is a directory!");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner("path_to_your_file");
        scanner.scanFile();
    }
}