import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37840_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/file.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // perform security-sensitive operation here
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}