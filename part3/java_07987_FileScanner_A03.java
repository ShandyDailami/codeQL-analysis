import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07987_FileScanner_A03 {
    public static void main(String[] args) {
        String fileName = "path_to_your_file";
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                // Here you can add code for security-sensitive operations related to injection attacks.
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}