import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08444_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("target/myFile.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Access attempt: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}