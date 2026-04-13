import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_39194_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("sample.txt"); // Replace with your file path
            Scanner scanner = new Scanner(file);

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