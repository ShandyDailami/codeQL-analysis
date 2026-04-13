import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_11229_FileScanner_A03 {

    private static List<String> uniquePaths = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/main/resources");

        fileSearch(path);

        for (String s : uniquePaths) {
            System.out.println(s);
        }
    }

    private static void fileSearch(Path path) throws IOException {
        try (Stream<Path> stream = Files.walk(path)) {
            stream.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    String content = new String(Files.readAllBytes(filePath));
                    if (content.contains("password") || content.contains("key")) {
                        uniquePaths.add(filePath.toString());
                    }
                }
            });
        }
    }
}