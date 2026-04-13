import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;

public class java_38495_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        FileSystems.newFileSystem(Path.of("."), null);

        // Creating a new file to scan
        File file = new File("example.txt");
        file.createNewFile();

        // Using FileScanner to scan the file
        FileSystems.newFileSystem(Path.of("."), null).newSimpleFileVisitor().visitFile(file.toPath(),
                attrs -> {
                    System.out.println("File name: " + attrs.getName());
                    System.out.println("File size: " + attrs.size() + " bytes");

                    // Opening the file for writing
                    file.createNewFile();
                    file.setWritable(true);
                    file.setReadable(true);

                    // Writing to the file
                    file.writeText("This is a test file. It is being written to by a FileScanner.");

                    return SimpleFileVisitor.super.visitFile(file.toPath(), attrs);
                });
    }
}