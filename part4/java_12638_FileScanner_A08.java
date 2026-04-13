import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_12638_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/file.txt");
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