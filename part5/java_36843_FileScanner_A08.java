import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_36843_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        try (DirectoryStream<Path> directories = Files.newDirectoryStream(path)) {
            directories.forEach(FileScanner::printDirectory);
        }
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path, "*.{txt,java}")) {
            files.forEach(FileScanner::printFile);
        }
    }

    private static void printDirectory(Path path) {
        System.out.println("Directory: " + path);
    }

    private static void printFile(Path path) throws IOException {
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.printf("File: %s, Size: %d bytes%n", path.getName(), attributes.size());
    }
}