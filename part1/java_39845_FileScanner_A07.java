import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39845_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("path/to/your/file")); // change to your file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // process the line here if necessary
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}