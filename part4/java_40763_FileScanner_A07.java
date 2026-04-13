import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40763_FileScanner_A07 {
    private static final String DIRECTORY_PATH = "/path/to/your/directory";
    private static final String FILE_EXTENSION = ".txt";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        handleLine(line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getPath());
                }
            }
        }
    }

    private static void handleLine(String line) {
        // Implementation of the logic to handle each line, security-sensitive operations related to A07_AuthFailure.
    }
}