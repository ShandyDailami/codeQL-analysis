import java.io.*;
import java.util.*;

public class java_02794_FileScanner_A08 {
    private File file;

    public java_02794_FileScanner_A08(String filePath) {
        file = new File(filePath);
    }

    public void scan() {
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        try (FileScanner scanner = new FileScanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while scanning the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        UniqueFileScanner scanner = new UniqueFileScanner("path/to/file");
        scanner.scan();
    }
}