import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_16729_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("A08_IntegrityFailure.txt");
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }
}