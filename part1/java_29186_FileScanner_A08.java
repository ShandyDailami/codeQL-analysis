import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29186_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file.txt");
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