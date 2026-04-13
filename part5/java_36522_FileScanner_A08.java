import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36522_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("target.txt"); // Assume we have a file called target.txt in our project root
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}