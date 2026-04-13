import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32001_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        try (FileScanner scanner = new FileScanner(directory)) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                System.out.println("Found file: " + file.getAbsolutePath());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}