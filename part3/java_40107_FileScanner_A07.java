import java.io.File;
import java.util.Scanner;

public class java_40107_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("./src/main/resources/auth.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}