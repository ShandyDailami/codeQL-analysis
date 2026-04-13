import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03127_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File file = new File("target/example.txt");
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