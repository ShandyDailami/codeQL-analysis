import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_29629_FileScanner_A01 {
    private static final String DIRECTORY_PATH = "C:\\path\\to\\directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);
        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.stream(files)
                    .filter(file -> file.isFile() && file.getName().endsWith(".txt"))
                    .forEach(Main::readFileContent);
        }
    }

    private static void readFileContent(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform security-sensitive operations related to A01_BrokenAccessControl
                // ...
            }
        } catch (Exception e) {
            // Handle exceptions related to security
            // ...
        }
    }
}