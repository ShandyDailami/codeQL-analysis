import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18482_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/test.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here, we're just echoing the line back to the console for demonstration purposes.
                // In a real-world scenario, you'd need to include more complex logic here to handle the data.
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}