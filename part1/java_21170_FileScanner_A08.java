import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_21170_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = args[0];
        Path dir = Paths.get(dirPath);

        try (Stream<Path> stream = Files.walk(dir)) {
            List<Path> matches = stream
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith(".txt"))
                    .collect(Collectors.toList());

            for (Path path : matches) {
                try (Stream<String> lines = Files.lines(path)) {
                    lines.forEach(System.out::println);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}