import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03126_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/A08_IntegrityFailure.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}