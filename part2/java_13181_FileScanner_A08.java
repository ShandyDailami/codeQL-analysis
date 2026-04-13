import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13181_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/input.txt"); // replace with your file
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // process line here
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}