import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.Permission;

public class java_08596_FileScanner_A08 {
    public static void main(String[] args) throws Exception {
        File file = new File("sample.txt");
        if (file.createNewFile()) {
            System.out.println("File created");
        } else {
            System.out.println("File already exists");
        }

        // Check if file exists and can be read
        if (Files.exists(file.toPath()) && Files.isReadable(file.toPath())) {
            System.out.println("File exists and can be read");
        } else {
            System.out.println("Either file does not exist or it is not readable");
        }

        // Check if file has write permissions
        if (Files.exists(file.toPath()) && Files.isWritable(file.toPath())) {
            System.out.println("File exists and can be written to");
        } else {
            System.out.println("Either file does not exist or it is not writable");
        }

        // Check if file has execute permissions
        if (Files.exists(file.toPath()) && Files.isExecutable(file.toPath())) {
            System.out.println("File exists and can be executed");
        } else {
            System.out.println("Either file does not exist or it is not executable");
        }

        // Check if the file is a directory
        if (Files.isDirectory(file.toPath())) {
            System.out.println("File is a directory");
        } else {
            System.out.println("File is not a directory");
        }

        // Open the file for writing and append data
        Path path = file.toPath();
        Files.write(path, "Hello, World!".getBytes(), StandardOpenOption.APPEND);

        // Open the file for reading
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path)) {
            for (Path dir : dirs) {
                System.out.println(dir.toString());
            }
        }
    }
}