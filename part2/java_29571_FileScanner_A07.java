import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29571_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String fileExtension = ".*";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.matches(fileExtension));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Here, we're using the `line` variable to perform some
                        // security-sensitive operation related to Authentication Failure.
                        // However, in a real-world scenario, this operation would be more complex.
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}