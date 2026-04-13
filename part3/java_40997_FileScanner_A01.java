import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40997_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/data.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Do something with the line, e.g., print it
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}