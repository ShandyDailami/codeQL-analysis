import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class java_30048_FileScanner_A03 {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("text.txt"))) {
            lines.map(Main::wordCount)
                .forEach(Main::printWordCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long wordCount(String line) {
        return line.split("\\s+").length;
    }

    private static void printWordCount(long count) {
        System.out.println("Number of words: " + count);
    }
}