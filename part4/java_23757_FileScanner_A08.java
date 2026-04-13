import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_23757_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");
        if (file.isDirectory()) {
            System.out.println("Scanning " + file.getAbsolutePath() + " for files...");
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error scanning file: " + e.getMessage());
            }
        } else {
            System.out.println("Error: " + file.getAbsolutePath() + " is not a directory");
        }
    }
}