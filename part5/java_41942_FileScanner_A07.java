import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41942_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/your/file");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Process the line here
            // For example, check for a specific string in the line
            if (line.contains("your_string")) {
                System.out.println("Security alert: Auth failure detected in line: " + line);
            }
        }

        scanner.close();
    }
}