import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class java_24809_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/file.txt"); // Use your file path
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line); // Use your security-sensitive operation here
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("End of file reached: " + e.getMessage());
        }
    }
}