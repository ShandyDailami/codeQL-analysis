import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_04503_FileScanner_A01 {

    public static void main(String[] args) throws Exception {
        FileSystem fileSystem = FileSystems.getDefault();
        Path path = fileSystem.getPath("target/broken-access-control-example");

        // Create a directory
        Files.createDirectory(path);

        // Try to create a file in the directory
        Files.createFile(path.resolve("file.txt"));

        // Now try to read the file
        BasicFileAttributes attributes = fileSystem.readAttributes(path.resolve("file.txt"), class情境11_类）
                .asBoolean();

        if (attributes.isReadable()) {
            System.out.println("File is readable");
        } else {
            System.out.println("File is not readable");
        }

        // Try to write to the file
        Files.write(path.resolve("file.txt"), "Some content".getBytes(), StandardOpenOption.CREATE);

        attributes = fileSystem.readAttributes(path.resolve("file.txt"), class情境11_类）
                .asBoolean();

        if (attributes.isWritable()) {
            System.out.println("File is writable");
        } else {
            System.out.println("File is not writable");
        }
    }
}