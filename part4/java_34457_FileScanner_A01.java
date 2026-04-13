import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_34457_FileScanner_A01 {
    public static void main(String[] args) {
        Path directory = Paths.get("your_directory_path");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path path : directoryStream) {
                if (Files.isReadable(path)) {
                    BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                    long permission = attributes.permissions();

                    if ((permission & 0x7FFF) == 0x7F00) { // Check if the file is executable
                        System.out.println("Executable: " + path);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}