import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_22193_FileScanner_A08 {

    public static void main(String[] args) {
        Path path = Paths.get(".");

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path, "*.txt")) {
            for (Path p : ds) {
                FileAttributes attrs = Files.readAttributes(p, BasicFileAttributes.class);
                long size = attrs.size();
                if (size < 100) {
                    System.out.println(p.toString() + " is a small text file (" + size + " bytes)");
                } else {
                    System.out.println(p.toString() + " is a large text file (" + size + " bytes)");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}