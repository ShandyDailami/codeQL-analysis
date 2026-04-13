import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12215_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/A08_IntegrityFailure.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // TODO: Process the line. 
                // For example, you can print the line, but not perform any operation.
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}