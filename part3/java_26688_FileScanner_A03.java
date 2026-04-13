import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26688_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        String directory = "/path/to/directory";
        String extension = "txt";
        String fileName = "A03_Injection." + extension;
        File file = new File(directory + "/" + fileName);

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // This line is intentionally left blank to demonstrate injection.
            // Actual application would not intentionally leave anything blank.
        }

        scanner.close();
    }
}