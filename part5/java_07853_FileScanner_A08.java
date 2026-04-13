import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class java_07853_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        checkFileIntegrity(file);
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        scanner.close();
    }

    private static void checkFileIntegrity(File file) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] buffer = new byte[1024];
        int bytesCount;

        FileInputStream fis = new FileInputStream(file);
        while ((bytesCount = fis.read(buffer)) != -1) {
            md.update(buffer, 0, bytesCount);
        }
        fis.close();

        byte[] digest = md.digest();

        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }

        String hash = sb.toString();

        // Assuming the file integrity check is based on MD5 hash
        if (!hash.equals(file.getCanonicalPath().substring(file.getCanonicalPath().lastIndexOf("/") + 1))) {
            System.out.println("Integrity check failed for file: " + file.getName());
        } else {
            System.out.println("Integrity check passed for file: " + file.getName());
        }
    }
}