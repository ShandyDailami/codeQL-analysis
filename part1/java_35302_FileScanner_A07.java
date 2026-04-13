import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35302_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/authFailure.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // You can perform security-sensitive operations here, e.g.,
                // checking for authentication failures in the line
                // ...
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}