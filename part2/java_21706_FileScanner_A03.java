import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21706_FileScanner_A03 {
    private static final String DIRECTORY = "C:\\path_to_directory";
    private static final String FILE_EXTENSION = "txt";

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));
        if (files != null) {
            for (File file : files) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Perform security-sensitive operations related to A03_Injection
                }
                scanner.close();
            }
        }
    }
}