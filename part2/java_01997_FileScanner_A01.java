import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class java_01997_FileScanner_A01 {
    private static final String FILE_PATH = "src/main/resources/file.txt";
    private static final String PERMISSION_DENIED_MESSAGE = "Permission Denied";

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        if (file.canRead()) {
            readFile(file);
        } else {
            System.out.println(PERMISSION_DENIED_MESSAGE);
        }
    }

    private static void readFile(File file) {
        Path path = Paths.get(file.getPath());
        try (List<String> lines = Files.readAllLines(path)) {
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}