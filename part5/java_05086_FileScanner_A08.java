import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05086_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Define the directory
        File dir = new File("/path/to/directory");

        // Create a directory stream
        try (DirectoryStream<File> files = Files.newDirectoryStream(dir.toPath(), path -> path.toString().endsWith(".txt"))) {
            for (File file : files) {
                // Create a scanner for each file
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}