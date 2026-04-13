import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01696_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("target/insecure_files.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This line is potentially dangerous for an injection attack
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}