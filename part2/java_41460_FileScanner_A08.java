import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41460_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file.txt"); // provide the path to the file
            Scanner scanner = new Scanner(file);

            System.out.println("Contents of the file:");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}