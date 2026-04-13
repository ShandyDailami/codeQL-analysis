import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26119_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path/to/file.txt"); // replace with your file path

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}