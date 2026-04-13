import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29812_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "path/to/directory";
        String fileExtension = "extension";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Security-sensitive operation here
                        // Example: print the line to console
                        System.out.println(line);
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}