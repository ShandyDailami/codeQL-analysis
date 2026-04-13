import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06040_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/file.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Here you can perform operations related to injection,
                // such as SQL injection or command injection.
                // Be creative and use the line to perform your operations.

                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}