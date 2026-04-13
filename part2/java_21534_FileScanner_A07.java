import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21534_FileScanner_A07 {

    public static void main(String[] args) {
        File directory = new File("path/to/directory");
        File file = new File("file.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}