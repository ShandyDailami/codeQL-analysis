import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39615_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        String directory = "/path/to/directory"; // Replace with your directory
        String extension = ".*.txt"; // Replace with your extension, such as ".txt"
        File directoryFile = new File(directory);
        File[] files = directoryFile.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                if (file.canRead()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println("Line found: " + line);
                    }
                    scanner.close();
                } else {
                    System.out.println("Cannot read file: " + file.getPath());
                }
            }
        }
    }
}