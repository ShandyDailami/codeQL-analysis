import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07413_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("target/injection.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Use of the line for security-sensitive operations
                // This is a placeholder for A03_Injection
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}