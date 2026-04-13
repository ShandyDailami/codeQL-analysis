import java.io.File;
import java.util.Scanner;

public class java_32876_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/file.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}