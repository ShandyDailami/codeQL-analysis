import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_35838_FileScanner_A08 {

    public static void main(String[] args) {
        Path path = Paths.get("path_to_directory"); // specify your directory here

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            directoryStream.forEach(file -> {
                try {
                    BasicFileAttributes attributes = Files.readAttributes(file, BasicFileAttributes.class);
                    System.out.println(file.getFileName() + " - Size: " + attributes.size() + " bytes");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}