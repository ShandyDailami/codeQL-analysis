import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02639_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");

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