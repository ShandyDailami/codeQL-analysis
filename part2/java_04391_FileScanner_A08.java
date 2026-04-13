import java.io.IOException;
import java.nio.file.*;
import java.security.SecureRandom;
import java.nio.file.attribute.BasicFileAttributes;

public class java_04391_FileScanner_A08 {
    private SecureRandom rand = new SecureRandom();
    private String generatedFileName;

    public void scanDirectory(Path dir) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                if (Files.isReadable(path)) {
                    processFile(path);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            generatedFileName = createUniqueFileName(file);
            FileOutputStream out = new FileOutputStream(generatedFileName);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            out.close();
            in.close();

            System.out.println("Processed file: " + generatedFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String createUniqueFileName(Path file) {
        String uniqueFileName;
        do {
            uniqueFileName = "/path/to/dir/" + (1 + rand.nextInt(99)) + file.getFileName().toString();
        } while (Files.exists(Path.of(uniqueFileName)));

        return uniqueFileName;
    }

    public static void main(String[] args) {
        Path dir = Paths.get("/path/to/dir");
        SecureFileScanner scanner = new SecureFileScanner();
        scanner.scanDirectory(dir);
    }
}