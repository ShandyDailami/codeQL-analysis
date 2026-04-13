import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35136_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}