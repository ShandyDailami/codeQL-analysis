import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05944_FileScanner_A08 {

    private static final String INTEGRITY_FAILURE_WORDS[] = { "A08_IntegrityFailure" };

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_your_file"); // replace with your file path
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (isLineIntegrityFailure(line)) {
                System.out.println(line);
            }
        }
        scanner.close();
    }

    private static boolean isLineIntegrityFailure(String line) {
        for (String word : INTEGRITY_FAILURE_WORDS) {
            if (line.contains(word)) {
                return true;
            }
        }
        return false;
    }
}