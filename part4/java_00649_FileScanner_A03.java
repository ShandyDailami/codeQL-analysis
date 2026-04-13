import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class java_00649_FileScanner_A03 {

    public static void main(String[] args) {
        String directory = "path/to/directory"; // replace with your directory
        String word = "injection"; // replace with your word

        try (Stream<Path> paths = Files.find(Paths.get(directory), 1, (path, attrs) -> path.toString().endsWith(".txt"))) {
            paths.forEach(path -> {
                try {
                    String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
                    long count = countOccurrences(content, word);
                    System.out.println("File: " + path + ", Word: " + word + ", Count: " + count);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private static long countOccurrences(String content, String word) {
        String[] words = content.split("\\s+");
        return Arrays.stream(words).filter(w -> w.equals(word)).count();
    }
}