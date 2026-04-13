import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_18342_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}