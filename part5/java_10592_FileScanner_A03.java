import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10592_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/injection.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                // Here we are not actually executing the code to prevent SQL Injection
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}