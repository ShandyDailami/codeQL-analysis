import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28245_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here, we assume that the file contains text and we're just printing it.
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}