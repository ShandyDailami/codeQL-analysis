import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34065_FileScanner_A08 {

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/A08_IntegrityFailure.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Add your code here to process the line
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}