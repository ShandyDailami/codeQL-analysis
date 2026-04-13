import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_38802_FileScanner_A08 {

    public static void main(String[] args) {
        Path start = Paths.get(".");
        try (Stream<Path> paths = Files.walk(start)) {
            paths.forEach(file -> {
                if (Files.isRegularFile(file) && file.toString().endsWith(".txt")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}