import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38812_FileScanner_A03 {
    public static void main(String[] args) {
        // Directory to scan
        String directoryPath = "path/to/directory";

        // Type of files to scan
        String fileType = "txt";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileType));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}