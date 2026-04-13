import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27157_FileScanner_A08 {

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/A08_IntegrityFailure.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here is where you would handle the line, for example, by logging it
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}