import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_22924_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDir = Paths.get("src"); // replace with your starting directory
        try (Stream<Path> walk = Files.walk(startingDir)) {
            walk.filter(path -> Files.isRegularFile(path))
               .forEach(file -> {
                   try {
                       BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                       if (attrs.isReadable() && attrs.isWritable()) {
                           System.out.println("File is readable and writable: " + file);
                       } else {
                           System.out.println("File is not readable or writable: " + file);
                       }
                   } catch (IOException e) {
                       System.out.println("Error checking permissions on file: " + file);
                   }
               });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}