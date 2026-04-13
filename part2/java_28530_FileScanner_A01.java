import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28530_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/data.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here we're only reading the file, we're not performing any operations
                // that could potentially be security-sensitive, as we're not doing any 
                // operations that would expose the file to a potential attacker.
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}