import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_08309_FileScanner_A01 {
    private static final String DIRECTORY = "C:\\example\\dir";
    private static final String FILE = "C:\\example\\file.txt";

    public static void main(String[] args) throws IOException {
        FileSystem fileSystem = FileSystems.newFileSystem(Paths.get(DIRECTORY), null);

        try (DirectoryStream<Path> dirStream = fileSystem.getDirectoryStream(Paths.get(DIRECTORY));
             RandomAccessFile raf = new RandomAccessFile(FILE, "rw")) {

            // Step 1: Write content into the file.
            for (Path path : dirStream) {
                raf.seek(path.toFile().length());
                raf.writeBytes(new String(Files.readAllBytes(path), StandardCharsets.UTF_8));
            }

            // Step 2: Read and print the content of the file.
            raf.seek(0);
            while (raf.getFilePointer() < raf.length()) {
                System.out.println(raf.readLine());
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Broken file system.");
        } catch (AccessDeniedException e) {
            System.out.println("Access denied.");
        }
    }
}