import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06747_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("C:\\path\\to\\your\\file"));

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}