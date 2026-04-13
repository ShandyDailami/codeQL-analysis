import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_15031_FileScanner_A01 {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        BasicFileAttributes attributes;

        try {
            attributes = Files.readAttributes(path, BasicFileAttributes.class);

            if (attributes.isDirectory()) {
                System.out.println("It is a directory");
            } else if (attributes.isRegularFile()) {
                System.out.println("It is a regular file");
            } else if (attributes.isSymbolicLink()) {
                System.out.println("It is a symbolic link");
            }

            // Security-sensitive operations related to A01_BrokenAccessControl
            // ...

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}