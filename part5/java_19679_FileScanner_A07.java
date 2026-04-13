import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class java_19679_FileScanner_A07 {
    public static void main(String[] args) {
        FileSystems.newFileSystem(Path.of("path/to/your/file"), null);

        new File("path/to/your/file").deleteOnExit();

        try (Scanner scanner = new Scanner(Path.of("path/to/your/file"))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();
                System.out.println("Line " + lineNumber + ": " + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}