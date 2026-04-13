import java.nio.file.*;
import java.nio.file.attribute.*;

import java.io.*;

public class java_04682_FileScanner_A08 {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("C:\\Users\\yourpath\\"); // Replace with your path
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    System.out.println("File: " + file.toString());
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