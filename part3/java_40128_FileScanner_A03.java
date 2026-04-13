import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40128_FileScanner_A03 {
    public void scanDirectory(String directoryPath) throws FileNotFoundException {
        File directory = new File(directoryPath);
        File[] allFiles = directory.listFiles();

        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Do something with the line, for example, print it
                        System.out.println(line);
                    }
                    scanner.close();
                }
            }
        }
    }
}