import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19205_FileScanner_A03 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/test.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is a security-sensitive operation.
                // It will execute harmful code if used to inject data.
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}