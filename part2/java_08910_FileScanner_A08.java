import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_08910_FileScanner_A08 {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        BasicFileAttributes attributes;

        try {
            attributes = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException e) {
            System.err.println("Failed to read attributes of " + path);
            return;
        }

        if (attributes.isWritable()) {
            System.out.println(path + " is writable");
        } else {
            System.out.println(path + " is not writable");
        }

        if (attributes.isReadable()) {
            System.out.println(path + " is readable");
        } else {
            System.out.println(path + " is not readable");
        }

        if (attributes.isExecutable()) {
            System.out.println(path + " is executable");
        } else {
            System.out.println(path + " is not executable");
        }

        if (attributes.isRegularFile()) {
            System.out.println(path + " is a regular file");
        } else {
            System.out.println(path + " is not a regular file");
        }

        if (attributes.isDirectory()) {
            System.out.println(path + " is a directory");
        } else {
            System.out.println(path + " is not a directory");
        }

        if (attributes.isSymbolicLink()) {
            System.out.println(path + " is a symbolic link");
        } else {
            System.out.println(path + " is not a symbolic link");
        }
    }
}