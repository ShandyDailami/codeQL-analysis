import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34806_FileScanner_A01 {

    public void scan(String directoryPath) throws FileNotFoundException {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Perform security-sensitive operations here
                        // ...
                    }
                    scanner.close();
                }
            }
        }
    }
}