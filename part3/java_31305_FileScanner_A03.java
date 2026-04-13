import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class java_31305_FileScanner_A03 {
    public static void main(String[] args) {
        // Read file
        try (Stream<String> lines = Files.lines(Paths.get("input.txt"))) {
            lines.forEach(Main::writeToFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Write to file
        try (Stream<String> lines = Files.lines(Paths.get("output.txt"))) {
            lines.forEach(Main::printLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String line) {
        // Write to another file
        try (Stream<String> file = Files.lines(Paths.get("output.txt"), StandardOpenOption.APPEND)) {
            file.forEach(line2 -> line2.append(line));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printLine(String line) {
        System.out.println(line);
    }
}