import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_21927_FileScanner_A03 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory)) {
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    FileAttributes fileAttributes = Files.readAttributes(path, FileAttributes.class);
                    if (fileAttributes.isSymbolicLink()) {
                        Path symbolicLinkPath = Files.readSymbolicLink(path);
                        System.out.println("Found symbolic link: " + symbolicLinkPath.toString());
                    } else {
                        System.out.println("Found regular file: " + path.toString());
                    }
                } else if (Files.isDirectory(path)) {
                    System.out.println("Found directory: " + path.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}