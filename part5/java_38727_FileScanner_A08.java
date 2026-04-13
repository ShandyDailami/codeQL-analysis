import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38727_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else {
            System.out.println("File not found: " + file.getPath());
        }
    }
}