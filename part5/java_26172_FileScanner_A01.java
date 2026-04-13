import java.io.IOException;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.BasicFileAttributes;

public class java_26172_FileScanner_A01 {

    public static void main(String[] args) {
        Path source = Paths.get("source.txt");
        Path target = Paths.get("target.txt");

        // Create directories if they don't exist
        try {
            Files.createDirectories(target.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Copy file
        try (InputStream in = Files.newInputStream(source);
             OutputStream out = Files.newOutputStream(target)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read and write with FileAttributes
        try (FileChannel in = FileChannel.open(source, StandardOpenOption.READ)) {
            FileChannel out = FileChannel.open(target, StandardOpenOption.WRITE);
            long position = 0;
            in.transferTo(position, Long.MAX_VALUE, out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Handle exceptions
        try (Stream<String> lines = Files.lines(source)) {
            lines.forEach(line -> {
                if (line.length() > 5) {
                    System.out.println(line);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Access permissions
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get("."), "*.java")) {
            for (Path path : dirs) {
                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println(path + " is " + (attrs.isReadable() ? "readable" : "not readable") +
                                   " and " + (attrs.isWritable() ? "writable" : "not writable"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}