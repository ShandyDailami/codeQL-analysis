import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25506_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/securityFile.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // You can perform security sensitive operations like checking for passwords
                // Here, we just print out the line from the file
                System.out.println("Line read from security file: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Security file not found!");
        }
    }
}