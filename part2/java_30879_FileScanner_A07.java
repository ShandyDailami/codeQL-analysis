import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_30879_FileScanner_A07 {
    public static void main(String[] args) {
        // Set up the file path
        Path path = Paths.get("src/main/resources/");

        // Use the Files class to get a FileVisitor
        try (FileVisitor<Path> visitor = Files.newFileVisitor(path)) {
            // When visiting a file, check if it's a directory
            // If it is, then continue to the next file
            // If it's not, then check if it's a file that should be read
            // If it is, then read the file and print its contents
            // If it's not, then print a message saying that it's not a readable file
            visitor.elements().forEach(element -> {
                if (element.isDirectory()) {
                    return;
                }

                try (Stream<String> stream = Files.lines(element)) {
                    stream.forEach(System.out::println);
                } catch (IOException e) {
                    System.out.println("Error reading file: " + element);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}