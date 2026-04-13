import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38447_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/file.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}