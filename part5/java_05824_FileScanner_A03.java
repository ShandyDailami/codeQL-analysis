import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05824_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("test.txt");
            Scanner scanner = new Scanner(fis);

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