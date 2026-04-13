import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10485_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        String fileExtension = ".*\\.txt";  // replace with your file extension

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // add code here to handle the line
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}