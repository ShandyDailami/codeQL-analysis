import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02260_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_file.txt");
            Scanner scanner = new Scanner(file);

            // Now you can use the scanner to read the file
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