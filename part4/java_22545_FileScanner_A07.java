import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22545_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line); // replace with your security-sensitive operation
                    }
                    scanner.close();
                }
            }
        }
    }
}