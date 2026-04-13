import java.nio.file.*;
import java.util.stream.*;

public class java_21234_FileScanner_A01 {
    public static void main(String[] args) {
        Path path = Paths.get("./data"); // replace with your directory

        try (Stream<Path> paths = Files.walk(path)) {
            paths.forEach(FileScanner::removeVowels);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void removeVowels(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            StringBuilder builder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                builder.append(line.replaceAll("[aeiouAEIOU]", ""));
                builder.append(System.lineSeparator());
            }

            Files.write(file, builder.toString().split("\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}