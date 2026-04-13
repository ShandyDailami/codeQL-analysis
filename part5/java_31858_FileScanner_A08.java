import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31858_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/data.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Assume that the file is safe and only contains valid integers
                int num = Integer.parseInt(line);
                // Continue with the rest of the code...
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}