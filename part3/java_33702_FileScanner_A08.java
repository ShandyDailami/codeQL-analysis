import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33702_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a FileScanner that can read the file from the current directory
        try (Scanner scanner = new Scanner(new File("."))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process each line
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}