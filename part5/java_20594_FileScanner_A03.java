import java.nio.file.*;
import java.io.*;

public class java_20594_FileScanner_A03 {
    public static void main(String[] args) throws Exception {
        Path start = Paths.get(".");

        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    BufferedReader reader = Files.newBufferedReader(file);
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    reader.close();
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}