import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39159_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        String extension = ".txt";  // replace with your file extension

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // process each line here
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}