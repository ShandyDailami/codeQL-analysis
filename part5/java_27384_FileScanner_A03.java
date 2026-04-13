import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27384_FileScanner_A03 {

    public static void main(String[] args) {

        File file = new File("src/main/resources/sample.txt");

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