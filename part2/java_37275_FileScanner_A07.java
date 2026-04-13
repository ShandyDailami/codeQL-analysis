import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37275_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform some security-sensitive operation here...
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}