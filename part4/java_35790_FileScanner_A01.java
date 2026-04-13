import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35790_FileScanner_A01 {
    private static final String BAD_PATH = "bad_path";

    public static void main(String[] args) {
        try {
            File file = new File(BAD_PATH);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // perform security-sensitive operation here
                System.out.println("Line: " + line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + BAD_PATH);
        }
    }
}