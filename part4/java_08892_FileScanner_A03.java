import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08892_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/injection.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Doing something with the line, such as executing SQL queries, etc.
                // However, this is a placeholder code and should be replaced with real business logic.
                System.out.println("Line read: " + line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}