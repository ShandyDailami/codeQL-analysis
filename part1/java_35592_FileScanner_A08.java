import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_35592_FileScanner_A08 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory, "*.txt")) {
            for (Path file : dirs) {
                BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                System.out.printf("Path : %s%n", file);
                System.out.printf("Directory: %s%n", attrs.isDirectory() ? "Directory" : (attrs.isRegularFile() ? "Regular File" : "Other"));
                System.out.printf("Size: %d%n", attrs.size());
                System.out.printf("Last modified: %s%n", formatLastModified(attrs.lastModifiedTime()));
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static String formatLastModified(FileTime fileTime) {
        return fileTime.toString().replace(" UTC", "");
    }
}