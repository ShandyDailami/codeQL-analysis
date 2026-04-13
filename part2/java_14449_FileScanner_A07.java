import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_14449_FileScanner_A07 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("C:\\path\\to\\your\\file"));
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