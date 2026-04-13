import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.function.*;
import java.security.*;

public class java_20015_FileScanner_A08 {

    public static void main(String[] args) {
        Path path = Paths.get("path/to/directory");

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    try {
                        verifyIntegrity(file);
                        System.out.println("File " + file + " has been verified successfully.");
                    } catch (InvalidKeyException | NoSuchAlgorithmException e) {
                        System.out.println("Error verifying file " + file + ": " + e.getMessage());
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void verifyIntegrity(Path file) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        Path hashFile = file.resolveSibling("/hash");

        Files.createFile(hashFile);
        Files.copy(file, hashFile, StandardCopyOption.REPLACE_EXISTING);

        Files.readAllLines(file).forEach(line -> md.update(line.getBytes()));

        byte[] expectedHash = md.digest();
        byte[] actualHash = Files.readAllBytes(hashFile);

        if (!Arrays.equals(expectedHash, actualHash)) {
            throw new InvalidKeyException("File integrity check failed.");
        }
    }
}