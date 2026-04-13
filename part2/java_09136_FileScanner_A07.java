import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_09136_FileScanner_A07 {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String path = "/path/to/directory";
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                try (InputStream in = new FileInputStream(file.toFile())) {
                    byte[] buffer = new byte[8192];
                    int bytesNumRead = 0;

                    while ((bytesNumRead = in.read(buffer)) != -1) {
                        md.update(buffer, 0, bytesNumRead);
                    }

                    byte[] digest = md.digest();

                    if (new String(digest).equals("desired hash")) {
                        System.out.println("File found with auth failure: " + file.toString());
                    }
                }

                return FileVisitResult.CONTINUE;
            }
        });
    }
}