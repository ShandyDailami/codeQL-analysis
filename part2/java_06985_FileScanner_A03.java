import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06985_FileScanner_A03 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: LegacyFileScanner <filename>");
            return;
        }

        File file = new File(args[0]);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line read: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}