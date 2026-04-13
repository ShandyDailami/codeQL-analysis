import java.io.IOException;
import java.nio.file.*;
import java.security.*;

public class java_38094_FileScanner_A08 {
    private static final String FILE_PATH = "/path/to/your/file";

    public static void main(String[] args) {
        try {
            Files.walkFileTree(Paths.get(FILE_PATH), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    FileVisitResult result = super.visitFile(file, attrs);
                    checkFileIntegrity(file);
                    return result;
                }
            });
        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void checkFileIntegrity(Path file) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream(file.toFile());
        byte[] buffer = new byte[8192];
        int bytesNumRead = 0;
        while ((bytesNumRead = fis.read(buffer)) != -1) {
            md.update(buffer, 0, bytesNumRead);
        }
        fis.close();

        byte[] hashedBytes = md.digest();
        String fileHashed = bytesToHex(hashedBytes);

        MessageDigest md2 = MessageDigest.getInstance("SHA-256");
        FileInputStream fis2 = new FileInputStream(file.toFile());
        int bytesNumRead2 = 0;
        while ((bytesNumRead2 = fis2.read(buffer)) != -1) {
            md2.update(buffer, 0, bytesNumRead2);
        }
        fis2.close();

        byte[] hashedCompareBytes = md2.digest();
        String fileHashedCompare = bytesToHex(hashedCompareBytes);

        if (!Arrays.equals(hashedBytes, hashedCompareBytes)) {
            throw new IntegrityFailureException("Integrity failure detected in file: " + file.toString());
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02X", b));
        }
        return builder.toString();
    }
}