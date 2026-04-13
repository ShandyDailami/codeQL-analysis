import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_26034_FileScanner_A03 {
    private static final String INPUT_DIRECTORY = "/path/to/input/directory";
    private static final String OUTPUT_DIRECTORY = "/path/to/output/directory";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        try (FileScanner scanner = new FileScanner(Paths.get(INPUT_DIRECTORY))) {
            while (scanner.hasNext()) {
                Path file = scanner.nextPath();
                if (Files.isRegularFile(file)) {
                    try (InputStream is = Files.newInputStream(file)) {
                        md.update(is.readAllBytes());
                        byte[] digest = md.digest();
                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            sb.append(String.format("%02x", b));
                        }
                        String hash = sb.toString();

                        Path outputFile = Paths.get(OUTPUT_DIRECTORY, hash);
                        Files.copy(file, outputFile, StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }
        }
    }
}