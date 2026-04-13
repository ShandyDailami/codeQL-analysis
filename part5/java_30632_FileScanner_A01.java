import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30632_FileScanner_A01 {

    public static void main(String[] args) {

        try {
            File file = new File("sample.txt");
            Scanner scanner = new Scanner(file);
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