import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_01247_FileScanner_A03 {
    private static final String DIRECTORY = "/path/to/directory";
    private static final String SEARCH_TERM = "search term";

    public static void main(String[] args) {
        Path path = Paths.get(DIRECTORY);
        try (Stream<Path> stream = Files.walk(path)) {
            List<Path> matches = stream
                    .filter(Files::isRegularFile)
                    .filter(p -> Files.readable(p))
                    .filter(p -> p.getFileName().toString().contains(SEARCH_TERM))
                    .collect(Collectors.toList());

            matches.forEach(p -> System.out.println("Match: " + p.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}