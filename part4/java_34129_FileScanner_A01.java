import java.io.*;
import java.nio.file.*;

public class java_34129_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a Path to a directory.
        Path directory = Paths.get("./your_directory_here");

        try (Stream<Path> paths = Files.walk(directory)) {
            for (Path path : paths) {
                if (!Files.isWritable(path)) {
                    System.out.println("Skipping non-writable file: " + path);
                } else {
                    try (InputStream in = Files.newInputStream(path)) {
                        // Read and print the contents of the file.
                        int r;
                        while ((r = in.read()) != -1) {
                            System.out.print((char) r);
                        }
                        System.out.println();
                    } catch (IOException ex) {
                        System.out.println("Error reading file: " + path);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error walking the directory tree.");
        }
    }
}