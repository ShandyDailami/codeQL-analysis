import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09878_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/file.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);

            // Here is the line that could cause an integrity failure.
            String sqlInjection = "SELECT * FROM Users WHERE username = '" + line + "' AND password = '" + line + "'";
        }

        scanner.close();
    }
}