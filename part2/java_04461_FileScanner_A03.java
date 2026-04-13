import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04461_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("injection_attack.txt"); // replace with your file path
        Scanner scanner = new Scanner(file);

        // Read file line by line and inject SQL commands
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Inject SQL commands
            String injectedLine = "-- " + line;
            System.out.println(injectedLine);
        }

        scanner.close();
    }
}