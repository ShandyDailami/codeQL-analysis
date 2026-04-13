import java.io.File;
import java.util.Scanner;

public class java_17731_FileScanner_A07 {
    public static void main(String[] args) {
        String fileName = "path_to_your_file";
        String searchString = "string_to_search";

        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchString)) {
                    System.out.println("Found the string: " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}