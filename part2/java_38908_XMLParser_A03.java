import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import sun.security.util.SecurityUtils;

public class java_38908_XMLParser_A03 {

    private static final String MD5 = "MD5";

    public void parse(String filename) throws Exception {
        File file = new File(filename);
        if (!file.exists()) {
            throw new Exception("File does not exist");
        }
        if (!file.canRead()) {
            throw new Exception("File is not readable");
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry = zipIn.getNextEntry();
        while (entry != null) {
            if (entry.getName().toLowerCase().endsWith(".xml")) {
                String md5 = getMd5Checksum(zipIn);
                if (!isValidMd5(md5)) {
                    throw new Exception("Invalid MD5 checksum");
                }
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }

    private String getMd5Checksum(ZipInputStream zipIn) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(MD5);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = zipIn.read(buffer)) > 0) {
            digest.update(buffer, 0, length);
        }
        return bytesToHex(digest.digest());
    }

    private boolean isValidMd5(String md5) {
        return SecurityUtils.isValidMD5(md5);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}