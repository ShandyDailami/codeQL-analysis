import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_11820_FileScanner_A03 {
    private static final String SHA256 = "SHA-256";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String dirPath = args[0];
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Path.of(dirPath));

        directoryStream.forEach(file -> {
            try {
                MessageDigest digest = MessageDigest.getInstance(SHA256);
                byte[] hash = digest.digest(Files.readAllBytes(file));

                String fileName = file.getFileName().toString();
                String hashString = bytesToHex(hash);

                System.out.println(fileName + ": " + hashString);
            } catch (Exception ex) {
                // Handle exception
            }
        });
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }
}