import java.io.File;
import java.util.Scanner;

public class java_35026_FileScanner_A01 {
    private static final String FILE_PATH = "path/to/your/file.txt"; // Replace this with your actual file path
    private static final String SEARCH_TERM = "security"; // This should be your sensitive word

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        Scanner scanner = new Scanner(file);

        boolean found = false;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.contains(SEARCH_TERM)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("The word '" + SEARCH_TERM + "' was found in the file.");
        } else {
            System.out.println("The word '" + SEARCH_TERM + "' was not found in the file.");
        }

        scanner.close();
    }
}