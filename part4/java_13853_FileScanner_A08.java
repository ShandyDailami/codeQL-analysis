import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13853_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("path/to/your/file.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist or cannot be read.");
        }
    }
}