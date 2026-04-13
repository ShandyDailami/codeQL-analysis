import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10910_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File file = new File("test.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is a security-sensitive operation related to A03_Injection.
                // NoSQL Injection is not allowed, so we'll not perform any operation on this line.
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}