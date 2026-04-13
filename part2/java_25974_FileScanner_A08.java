import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25974_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_file");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            // Add your security-sensitive operation here, e.g., check for integrity failure
        }

        scanner.close();
    }
}