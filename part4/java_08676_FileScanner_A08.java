import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_08676_FileScanner_A08 {
    public static void main(String[] args) {
        Path path = Paths.get(".");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path, "*.java")) {
            for (Path dir : dirs) {
                File file = dir.toFile();
                System.out.println("File: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}