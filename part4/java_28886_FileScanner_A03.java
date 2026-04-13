import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28886_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("C:\\path\\to\\your\\file.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // The next step depends on how you're planning to exploit this line.
                // You could use a command injection, a format string vulnerability,
                // or even the ability to read arbitrary files on the user's system.
                // Here, we're just reading the file.
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}