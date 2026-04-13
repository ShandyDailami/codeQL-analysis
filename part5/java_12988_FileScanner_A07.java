import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class java_12988_FileScanner_A07 {

    public static void main(String[] args) {
        String directory = System.getProperty("user.dir");
        File file = new File(directory);
        File[] listOfFiles = file.listFiles((dir, name) -> name.endsWith(".txt"));

        if (listOfFiles != null) {
            for (File f : listOfFiles) {
                try {
                    readFile(f.getPath());
                } catch (IOException e) {
                    System.out.println("Error reading file: " + f.getName());
                }
            }
        }
    }

    private static void readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        // Security-sensitive operations
        // For example, attempt to execute code on each line
        for (String line : lines) {
            // Uncomment the following line to attempt to execute code
            // Runtime.getRuntime().exec(line);
        }
    }
}