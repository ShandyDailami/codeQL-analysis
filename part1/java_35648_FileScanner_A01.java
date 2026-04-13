import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35648_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("your_directory");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
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