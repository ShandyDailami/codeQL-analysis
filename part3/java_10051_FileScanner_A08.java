import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_10051_FileScanner_A08 {

    private static final String HASH_ALGORITHM = "SHA-1";

    public void scanDirectory(String directoryPath, String fileExtension) throws IOException, NoSuchAlgorithmException {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(fileExtension)) {
                    checkFileIntegrity(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file.getAbsolutePath(), fileExtension);
                }
            }
        }
    }

    private void checkFileIntegrity(File file) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel channel = raf.getChannel();

        byte[] hashBytes = new byte[(int) channel.size()];
        channel.read(channel.fileKey(), channel, hashBytes);
        channel.close();
        raf.close();

        String hashString = bytesToHex(hashBytes);
        String knownHash = getKnownHash(file);

        if (!hashString.equals(knownHash)) {
            System.out.println("Integrity failure detected in file: " + file.getAbsolutePath());
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

    private String getKnownHash(File file) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel channel = raf.getChannel();

        byte[] hashBytes = new byte[(int) channel.size()];
        channel.read(channel.fileKey(), channel, hashBytes);
        channel.close();
        raf.close();

        return bytesToHex(digest.digest(hashBytes));
    }
}