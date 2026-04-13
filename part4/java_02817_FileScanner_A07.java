import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02817_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/file");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}