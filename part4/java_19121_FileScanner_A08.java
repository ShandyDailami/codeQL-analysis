import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_19121_FileScanner_A08 {
    public static void main(String[] args) {
        Path startingPath = Paths.get("src");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingPath)) {
            for (Path path : directoryStream) {
                if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                    printDirectoryListing(path);
                } else {
                    System.out.println(path);
                }
            }
        } catch (InvalidPathException e) {
            System.out.println("Invalid path: " + e.getPath());
        } catch (IOException e) {
            System.out.println("Error accessing path: " + e.getPath());
        }
    }

    private static void printDirectoryListing(Path path) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            for (Path file : directoryStream) {
                System.out.println(file.toString());
            }
        } catch (IOException e) {
            System.out.println("Error accessing files in " + path);
        }
    }
}