import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_33955_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A")) {
                    System.out.println("String 'A' found in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}