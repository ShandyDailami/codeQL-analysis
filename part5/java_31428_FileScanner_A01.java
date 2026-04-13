import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31428_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/your/file");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // You can perform operations on each line, but not inside a loop
            // For example, you could print each line:
            System.out.println(line);
        }

        scanner.close();
    }
}