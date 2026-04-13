import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07668_FileScanner_A07 {

    public static void main(String[] args) {
        try {
            File file = new File("src/main/java/A07_AuthFailure.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // This is a security-sensitive operation
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}