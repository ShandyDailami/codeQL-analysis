import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19171_FileScanner_A08 {
    public static void main(String[] args) {
        String filePath = "src/main/resources/file.txt"; // Path to your file
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Remove the line breaks to prevent the integrity failure
                line = line.replace("\n", "");
                // Do not print the line if it is empty to prevent the integrity failure
                if (!line.isEmpty()) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}