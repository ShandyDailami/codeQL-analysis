import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_35546_FileScanner_A03 {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        BasicFileAttributes attributes;

        try {
            attributes = Files.readAttributes(path, BasicFileAttributes.class);
            if (attributes.isRegularFile()) {
                System.out.println("This path is a regular file.");
            } else if (attributes.isDirectory()) {
                System.out.println("This path is a directory.");
            } else if (attributes.isSymbolicLink()) {
                System.out.println("This path is a symbolic link.");
            } else if (attributes.isOther()) {
                System.out.println("This path is a other type of file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}