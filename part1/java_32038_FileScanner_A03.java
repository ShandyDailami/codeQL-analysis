import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_32038_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_file");
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