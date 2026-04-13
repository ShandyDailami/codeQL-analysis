import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40177_FileScanner_A03 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/main/resources/file.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}