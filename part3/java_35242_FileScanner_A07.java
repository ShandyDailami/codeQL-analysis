import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_35242_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("your_string")) {
                    System.out.println("String found!");
                    // Do something with the line (e.g., replace with another string)
                }
           
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}