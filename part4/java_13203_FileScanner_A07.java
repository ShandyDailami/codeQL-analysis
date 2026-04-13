import java.io.*;
import java.security.*;

public class java_13203_FileScanner_A07 {
    private static final String FILE_PATH = "path_to_your_file";
    private static final String SECRET_KEY = "your_secret_key";

    public static void main(String[] args) {
        try {
            scanFile(FILE_PATH, SECRET_KEY);
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void scanFile(String filePath, String secretKey) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(secretKey.getBytes());
        byte[] secretKeyBytes = md.digest();

        File file = new File(filePath);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int bytesNumRead = 0;

            while ((bytesNumRead = fis.read(buffer)) != -1) {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                digest.update(secretKeyBytes, 0, secretKeyBytes.length);
                digest.update(buffer, 0, bytesNumRead);
                byte[] newSecretKeyBytes = digest.digest();

                if (Arrays.equals(newSecretKeyBytes, secretKeyBytes)) {
                    System.out.println("Access granted to file: " + file.getAbsolutePath());
                }
            }

            fis.close();
        } else {
            System.out.println("File does not exist.");
        }
    }
}