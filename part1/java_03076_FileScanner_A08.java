import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03076_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/file.txt");  // replace with your file path
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Do something with the line, for example, print it
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}