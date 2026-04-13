import java.nio.file.*;
import java.io.*;

public class java_36591_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        Path startingPoint = Paths.get(".");
        listFiles(startingPoint, true);
    }

    private static void listFiles(Path path, boolean showPaths) throws Exception {
        try (Stream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path p : stream) {
                if (Files.isDirectory(p)) {
                    if (showPaths) {
                        System.out.println("Directory: " + p);
                    }
                    listFiles(p, showPaths);
                } else {
                    if (Files.isReadable(p)) {
                        System.out.println("File: " + p);
                    }
                }
            }
        }
    }
}