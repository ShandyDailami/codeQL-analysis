import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04341_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("A08_IntegrityFailure.txt");
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // TODO: perform integrity check on the line
            }
            scanner.close();
        } else {
            System.out.println("File not found!");
        }
    }
}