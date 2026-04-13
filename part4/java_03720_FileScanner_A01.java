import java.nio.file.*;
import java.io.*;

public class java_03720_FileScanner_A01 {
    public static void main(String[] args) {
        Path startPath = Paths.get(".");
        try (Stream<Path> paths = Files.walk(startPath)) {
            paths.forEach(file -> {
                try (Stream<String> lines = Files.lines(file)) {
                    lines.forEach(System.out::println);
                } catch (IOException e) {
                    System.out.println("Error reading file: " + file);
                }
            });
        } catch (IOException e) {
            System.out.println("Error walking the directory tree");
        }
    }
}