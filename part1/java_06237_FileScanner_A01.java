import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_06237_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("target");
        BasicFileAttributes attributes;

        // Check if directory exists
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }

        // Check if directory is readable
        if (Files.isReadable(path)) {
            System.out.println("Directory is readable");
        } else {
            System.out.println("Directory is not readable");
        }

        // Check if directory is writable
        if (Files.isWritable(path)) {
            System.out.println("Directory is writable");
        } else {
            System.out.println("Directory is not writable");
        }

        // Check if directory is executable
        if (Files.isExecutable(path)) {
            System.out.println("Directory is executable");
        } else {
            System.out.println("Directory is not executable");
        }

        // Check if directory is a file
        if (Files.isRegularFile(path)) {
            System.out.println("Path is a file");
        } else {
            System.out.println("Path is not a file");
        }

        // Check if directory is a directory
        if (Files.isDirectory(path)) {
            System.out.println("Path is a directory");
        } else {
            System.out.println("Path is not a directory");
        }
    }
}