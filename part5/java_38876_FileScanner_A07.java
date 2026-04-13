import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class java_38876_FileScanner_A07 {

    private static final String HASH_ALGORITHM = "SHA-1";
    private static final int MAX_BUF_SIZE = 1024;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory to scan:");
        String dir = scanner.next();
        scanner.close();

        File file = new File(dir);
        if (file.exists() && file.isDirectory()) {
            findFiles(file, ".*\\.txt$");
        } else {
            System.out.println("Invalid directory");
        }
    }

    private static void findFiles(File file, String regex) {
        File[] files = file.listFiles((dir, name) -> new File(dir, name).isFile() && name.matches(regex));
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    try {
                        System.out.println("File: " + f.getPath());
                        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
                        byte[] buffer = new byte[MAX_BUF_SIZE];
                        int length = 0;
                        FileInputStream fis = new FileInputStream(f);
                        while ((length = fis.read(buffer)) != -1) {
                            md.update(buffer, 0, length);
                        }
                        byte[] digest = md.digest();
                        System.out.println("Hash: " + bytesToHex(digest));
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
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