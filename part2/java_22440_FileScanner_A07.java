import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22440_FileScanner_A07 {
    private static final String DIRECTORY = "/path/to/your/directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // TODO: Implement authentication failure detection here
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}