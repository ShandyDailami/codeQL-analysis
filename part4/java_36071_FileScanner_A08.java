import java.io.File;
import java.util.Scanner;

public class java_36071_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/test.txt");

        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}