import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40209_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/authFailureData.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // process line...
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file doesn't exist!");
        }
    }
}