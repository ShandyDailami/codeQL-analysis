import java.io.File;
import java.util.Scanner;

public class java_36029_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("your_specific_word")) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}