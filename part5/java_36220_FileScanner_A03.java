import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36220_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        File[] textFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (textFiles != null) {
            for (File textFile : textFiles) {
                try (Scanner scanner = new Scanner(textFile)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // process the line here
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}