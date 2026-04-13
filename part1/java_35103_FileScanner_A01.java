import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class java_35103_FileScanner_A01 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file:");
        String path = scanner.nextLine();
        File file = new File(path);

        if (file.exists() && !file.isDirectory()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[1024];
                int length;

                while ((length = fis.read(buffer)) > 0) {
                    md.update(buffer, 0, length);
                }

                byte[] digest = md.digest();
                StringBuilder sb = new StringBuilder();

                for (byte b : digest) {
                    sb.append(String.format("%02x", b));
                }

                System.out.println("MD5 Hash of " + file.getName() + " is: " + sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found!");
        }
    }
}