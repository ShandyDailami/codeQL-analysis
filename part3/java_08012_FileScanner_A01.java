import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08012_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("path_to_file.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // You might want to sanitize or sanitize the input here, depending on your specific use case
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}