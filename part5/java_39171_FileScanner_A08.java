import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39171_FileScanner_A08 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("A08_IntegrityFailure.txt"))) {
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // Skip first line which is usually the filename
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.startsWith("#")) {
                    // Process the line
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}