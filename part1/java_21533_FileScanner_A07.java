import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21533_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file.txt"); // replace with your file path
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.contains("A07_AuthFailure")) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}