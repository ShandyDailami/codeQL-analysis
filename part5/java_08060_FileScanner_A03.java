import java.io.File;
import java.util.Scanner;

public class java_08060_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/file.txt"); // replace with your file path
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}