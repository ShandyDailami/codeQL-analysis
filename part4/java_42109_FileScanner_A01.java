import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_42109_FileScanner_A01 {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        BasicFileAttributes attributes;

        try {
            attributes = Files.readAttributes(path, BasicFileAttributes.class);

            if (attributes.isReadable() && attributes.isWritable()) {
                System.out.println("The path is both readable and writable.");
            } else if (attributes.isReadable()) {
                System.out.println("The path is readable but not writable.");
           
            } else {
                System.out.println("The path is not readable or writable.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}