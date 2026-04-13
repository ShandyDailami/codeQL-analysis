import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09378_FileScanner_A07 {
    private static final String DIRECTORY = "src/main/resources";

    public static void main(String[] args) {
        File file = new File(DIRECTORY);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(detectAuthFailure(line));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static String detectAuthFailure(String source) {
        if (source.contains("authFailure")) {
            return "Potential auth failure detected!";
        } else {
            return "No auth failure detected.";
        }
    }
}