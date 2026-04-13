import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_03820_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/path/to/directory");
        BasicFileAttributes attributes;

        try (FileScanner scanner = FileSystems.newFileScanner(path,
                FileAttributeView.BasicFileAttributes.class)) {
            for (Path file : scanner.iterateFiles()) {
                try (InputStream in = Files.newInputStream(file,
                        LinkOption.NOFOLLOW_LINKS)) {
                    attributes = Files.readAttributes(file, BasicFileAttributes.class);
                    long size = attributes.size();
                    System.out.println(file.toString() + ": " + size + " bytes");
                } catch (UnsupportedOperationException e) {
                    System.out.println("Broken link " + file.toString());
                } catch (IOException e) {
                    System.out.println("I/O Error " + file.toString());
                }
            }
        }
    }
}