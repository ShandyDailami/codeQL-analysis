import java.nio.file.*;
import java.io.*;

public class java_10594_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingPath = Paths.get(".");
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(startingPath, "*.java")) {
            for (Path path : dirStream) {
                System.out.println("Processing file: " + path.toString());
                // Here you would add code to read and analyze the contents of the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}