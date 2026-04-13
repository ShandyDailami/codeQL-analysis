import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.nio.file.attribute.*;

public class java_19459_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources");
        try (Stream<Path> stream = Files.walk(path)) {
            for (Path file: stream.filter(Files::isRegularFile).sorted()) {
                FileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                long size = Files.size(file);
                FileTime time = attrs.lastModifiedTime();
                long lastModifiedTime = time.toMillis();

                System.out.printf("File: %s, Size: %d bytes, Last Modified: %d%n", file.toString(), size, lastModifiedTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}