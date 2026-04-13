import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41201_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("A07_AuthFailure.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                // Add security-sensitive operations here, such as checking for login failures
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}