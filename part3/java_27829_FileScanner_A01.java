import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_27829_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        try (Stream<Path> walk = Files.walk(startingDirectory)) {
            walk.filter(Files::isRegularFile).forEach(file -> {
                try {
                    BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                    if (attrs.isReadable() && !attrs.isWritable()) {
                        System.out.println("Broken access control: Readable file: " + file);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}