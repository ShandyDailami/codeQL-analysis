import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_10812_FileScanner_A07 {
    private static final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.txt");

    public static void main(String[] args) {
        try (Stream<Path> paths = Files.find(Paths.get("."), Integer.MAX_VALUE,
            (path, attrs) -> matcher.matches(path.getFileName()))) {
            paths.forEach(file -> {
                try {
                    if (file.getFileSystem() != null) {
                        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}