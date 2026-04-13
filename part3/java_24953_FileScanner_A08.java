import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_24953_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File testFile = new File("test.txt");
            Scanner scanner = new Scanner(testFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file 'test.txt' was not found.");
        }
    }
}