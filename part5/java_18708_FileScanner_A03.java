import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18708_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/testFile.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                // This is a basic sanitization mechanism. In a real application,
                // you would want to sanitize the input to prevent SQL Injection attacks.
                // This example does not include the sanitization process.
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}