import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41957_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/sample.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);

            // Removing the comment for demonstration purpose.
            // In a real-world scenario, you would want to avoid this for security reasons.
            // Commented out for demonstration purpose.
            // System.out.println("Commented out for demonstration purpose.");
        }

        scanner.close();
    }
}