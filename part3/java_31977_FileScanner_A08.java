import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class java_31977_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/test.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + file.getName() + " does not exist.");
        }
    }
}