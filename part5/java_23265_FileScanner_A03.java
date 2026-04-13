import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_23265_FileScanner_A03 {

    public static void main(String[] args) {
        String filePath = "/path/to/your/file.txt"; // replace with your file path
        readFile(filePath);
    }

    public static void readFile(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}