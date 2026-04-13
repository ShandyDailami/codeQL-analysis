import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35847_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("path/to/your/file");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}