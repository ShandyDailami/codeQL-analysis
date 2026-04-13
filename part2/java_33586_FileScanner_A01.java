import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33586_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is a place where you might do something sensitive
                // You should replace this with your actual logic
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}