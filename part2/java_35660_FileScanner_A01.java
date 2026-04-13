import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35660_FileScanner_A01 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("access_control_file.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}