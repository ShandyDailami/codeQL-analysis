import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03668_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_file");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
                // Add your security-sensitive operation here
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}