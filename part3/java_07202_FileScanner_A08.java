import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_07202_FileScanner_A08 {
    private static final String HASH_ALGORITHM = "SHA-256";

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String directoryPath = "."; // change this to your directory
        String hash;

        File directory = new File(directoryPath);

        // Get the hash of the directory
        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
        md.update(directory.getAbsolutePath().getBytes());
        byte[] dirBytes = md.digest();
        hash = bytesToHex(dirBytes);

        // Use FileFilter to check files
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                try {
                    // Get the hash of the file
                    MessageDigest md2 = MessageDigest.getInstance(HASH_ALGORITHM);
                    md2.update(pathname.getBytes());
                    byte[] fileBytes = md2.digest();
                    String fileHash = bytesToHex(fileBytes);

                    // Check if the file's hash is equal to the directory's hash
                    return fileHash.equals(hash);
                } catch (NoSuchAlgorithmException e) {
                    throw new IllegalStateException(e);
                }
            }
        };

        // Scan the directory for files
        File[] files = directory.listFiles(fileFilter);

        // Print the names and hashes of the files
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getAbsolutePath());
                System.out.println("Hash: " + calculateHash(file));
            }
        }
    }

    private static String calculateHash(File file) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
        md.update(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
        byte[] fileBytes = md.digest();
        return bytesToHex(fileBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02x", bytes[i]));
        }
        return sb.toString();
    }
}