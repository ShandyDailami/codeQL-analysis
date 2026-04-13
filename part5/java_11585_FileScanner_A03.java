import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11585_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        String fileExtension = ".txt";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    Scanner scanner = new Scanner(fis);
                    scanner.useDelimiter("\\Z");
                    String contents = scanner.next();
                    System.out.println("File contents: " + contents);
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getName());
                }
            }
        }
    }
}