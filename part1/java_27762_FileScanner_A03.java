import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_27762_FileScanner_A03 {
    public static void main(String[] args) {
        Path path = Paths.get(".");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path, "*.txt")) {
            for (Path file : directoryStream) {
                FileAttributes attributes = Files.readAttributes(file, BasicFileAttributes.class);

                if (attributes.isWritable()) {
                    System.out.println("Writable file: " + file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}