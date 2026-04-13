import java.io.File;
import java.util.Scanner;

public class java_06981_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("password")) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}