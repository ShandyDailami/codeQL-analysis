import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27180_FileScanner_A08 {

    public static void main(String[] args) {
        String filePath = "path_to_your_file"; // provide your file path

        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}