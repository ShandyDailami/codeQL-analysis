import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30261_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "/path/to/your/file.txt"; // Replace with your actual file path
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        System.out.println("Lines containing 'A08_IntegrityFailure':");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("A08_IntegrityFailure")) {
                System.out.println(line);
            }
        }

        scanner.close();
    }
}