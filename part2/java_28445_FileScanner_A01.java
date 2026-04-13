import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28445_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/file.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.startsWith("#")) {
                System.out.println(line);
            }
        }

        scanner.close();
    }
}