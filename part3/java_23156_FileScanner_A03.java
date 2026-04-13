import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23156_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("path_to_your_file.txt"); // replace with your file path
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Injection-related operation, please note that this is a security issue and not a good practice.
                System.out.println("Injected line: " + line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}