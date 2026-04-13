import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27097_FileScanner_A08 {

    public static void main(String[] args) {
        String filePath = "path_to_your_file";  // replace with your file path
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // process the line
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}