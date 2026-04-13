import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28818_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/injection.txt");
        Scanner scanner = new Scanner(file);

        // Use the scanner to read from the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // This is a security-sensitive operation related to injection.
            // You can add your own code here.
            System.out.println(line);
        }

        scanner.close();
    }
}