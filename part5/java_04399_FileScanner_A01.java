import java.io.File;
import java.util.Scanner;

public class java_04399_FileScanner_A01 {

    public static void main(String[] args) {
        try {
            File file = new File("data.txt");

            // FileScanner can read a file line by line
            Scanner scanner = new Scanner(file);

            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

                // In a real application, you would want to perform security-sensitive operations
                // here, but for simplicity, we'll just print the line back out to the console
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}