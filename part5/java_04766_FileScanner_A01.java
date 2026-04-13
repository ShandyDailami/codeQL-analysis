import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04766_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        String searchText = "searchText";  // replace with your search text

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains(searchText)) {
                            System.out.println("Found line: " + line);
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}