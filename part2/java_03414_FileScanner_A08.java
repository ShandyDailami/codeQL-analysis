import java.io.*;
import java.nio.file.*;

public class java_03414_FileScanner_A08 {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path, "*.txt")) {
            for (Path dir : dirs) {
                File file = dir.toFile();
                if (file.canRead()) {
                    System.out.println("Reading file: " + file.getAbsolutePath());
                } else {
                    System.out.println("Cannot read file: " + file.getAbsolutePath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}