import java.io.File;
import java.util.Scanner;

public class java_34747_FileScanner_A07 {
    public static void main(String[] args) {
        // Path to the file
        String path = "path_to_your_file";
        File file = new File(path);

        // Keyword to search
        String keyword = "A07_AuthFailure";

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(keyword)) {
                    System.out.println("Line contains keyword: " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}