import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_25270_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingPath = Paths.get(".");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(startingPath, "A01_BrokenAccessControl.txt")) {
            for (Path path : stream) {
                BasicFileAttributes attributes;
                try (FileChannel channel = FileSystems.newFileChannel(path, EnumSet.of(StandardFileAttributes.StandardFileAttributes.size))) {
                    attributes = channel.readAttributes();
                    if (attributes.size() != 0) {
                        System.out.println("File is not empty: " + path);
                    }
                } catch (IOException e) {
                    System.out.println("Failed to read attributes of " + path);
               
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to list files in " + startingPath);
        }
    }
}