import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_41530_FileScanner_A08 {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        // Define the directory to scan
        File directory = new File("path_to_directory");

        // Get the MD5 hash sum algorithm
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Loop over all files in the directory
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                // Calculate the hash sum of the file
                try (InputStream fis = new FileInputStream(file)) {
                    byte[] buffer = new byte[1024];
                    int n = 0;
                    while ((n = fis.read(buffer)) != -1) {
                        md.update(buffer, 0, n);
                    }
                    byte[] digest = md.digest();

                    // Compare the hash sum of the file with the hash sum in the directory
                    // If they match, the file is integral and prints a success message
                    if (compareMD5(digest, getMD5(file))) {
                        System.out.println("File " + file.getName() + " is integral");
                    } else {
                        System.out.println("File " + file.getName() + " is corrupted");
                    }
                }
            }
        }
    }

    // Method to calculate MD5 hash sum of a file
    private static String getMD5(File file) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        try (InputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int numRead = 0;
            while ((numRead = fis.read(buffer)) != -1) {
                md.update(buffer, 0, numRead);
            }
            return bytesToHex(md.digest());
        }
    }

    // Method to compare two MD5 hash sums
    private static boolean compareMD5(byte[] a, byte[] b) {
        if (a.length != b.length) return false;
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result = a[i] ^ b[i];
            if (result != 0) return false;
        }
        return true;
    }

    // Method to convert byte array to hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(Character.forDigit((b >> 4) & 0xF, 16));
            sb.append(Character.forDigit(b & 0xF, 16));
        }
        return sb.toString();
    }
}