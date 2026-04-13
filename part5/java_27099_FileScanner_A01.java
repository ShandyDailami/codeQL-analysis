import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27099_FileScanner_A01 {
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
            System.out.println("File not found: " + file.getPath());
        }
    }
}