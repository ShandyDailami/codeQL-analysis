import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class java_09658_FileScanner_A08 {

    public static void main(String[] args) {
        Path rootDir = Paths.get(".").toAbsolutePath();
        FileSystem fs = rootDir.getFileSystem();

        try (Stream<Path> walk = fs.find(rootDir, ".*\\.java".matcher())) {
            walk.forEach(file -> {
                try (Stream<String> lines = Files.lines(file)) {
                    lines.filter(line -> line.contains("A08_IntegrityFailure")).forEach(System.out::println);
                } catch (IOException e) {
                    System.out.println("Error reading file: " + file);
                }
            });
        } catch (IOException e) {
            System.out.println("Error accessing directory: " + rootDir);
        }
    }
}