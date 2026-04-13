import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_38561_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        Path dir = Paths.get(directoryPath);

        try (Stream<Path> paths = Files.walk(dir)) {
            paths.forEach(file -> {
                try {
                    Path absolutePath = file.toAbsolutePath();
                    long length = Files.size(file);
                    System.out.println("Path: " + absolutePath);
                    System.out.println("Length: " + length);

                    // Read the content of the file synchronously.
                    // This is safe as long as the file is not too large.
                    // In a real application, you would use a larger, blocking I/O operation here.
                    try (InputStream in = Files.newInputStream(file)) {
                        byte[] bytes = new byte[1024];
                        int read;
                        while ((read = in.read(bytes)) != -1) {
                            System.out.write(bytes, 0, read);
                        }
                    }

                    System.out.println();
                } catch (IOException e) {
                    System.out.println("Failed to process " + file);
                }
            });
        } catch (IOException e) {
            System.out.println("Failed to walk the directory tree");
        }
    }
}