import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23945_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/A01_BrokenAccessControl.txt");

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