import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06338_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/example.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Do something with line, for example, print it out
            System.out.println(line);
        }

        scanner.close();
    }
}