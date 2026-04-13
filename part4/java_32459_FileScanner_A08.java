import java.io.File;
import java.util.Scanner;

public class java_32459_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Security")) {
                    System.out.println("The file contains the word 'Security'!");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}