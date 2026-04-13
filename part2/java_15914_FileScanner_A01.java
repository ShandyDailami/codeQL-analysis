import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15914_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/test.txt"));  // Reads file from resources folder
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);  // Simple print for demonstration purposes
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}