import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21239_FileScanner_A01 {
    public static void main(String[] args) {
        String currentDir = new File(".").getAbsolutePath();

        try (Scanner scanner = new Scanner(new File(currentDir + "/file.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}