import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_41742_FileScanner_A08 {

    public static void main(String[] args) {

        File file = new File("path_to_your_file");
        Scanner scanner = null;

        try {
            scanner = new Scanner(new FileReader(file));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // This is a security-sensitive operation
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}