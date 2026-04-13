import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_10061_FileScanner_A07 {
    public static void main(String[] args) {
        String path = "/path/to/directory"; // replace with your directory
        scanDirectory(path);
    }

    private static void scanDirectory(String path) {
        File file = new File(path);
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    scanDirectory(f.getPath());
                } else {
                    try {
                        checkFile(f);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void checkFile(File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] buffer = new byte[1024];
        int length;

        while ((length = fis.read(buffer)) != -1) {
            md.update(buffer, 0, length);
        }

        byte[] digest = md.digest();

        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }

        if (sb.toString().equals("A07_AuthFailure")) {
            System.out.println("File: " + file.getPath() + " has MD5 hash of 'A07_AuthFailure'");
        }

        fis.close();
    }
}