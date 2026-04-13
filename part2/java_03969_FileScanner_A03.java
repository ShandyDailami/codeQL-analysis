import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_03969_FileScanner_A03 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        File file = new File("C:/Temp");  // replace with your directory
        ScanDirectory(file, "");
    }

    public static Map<String, String> GetHash(File file, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] fileBytes = md.digest(file.getAbsolutePath());

        StringBuilder hash = new StringBuilder();
        for (byte b : fileBytes) {
            hash.append(String.format("%02x", b));
        }

        Map<String, String> result = new HashMap<>();
        result.put(file.getPath(), hash.toString());
        return result;
    }

    public static void ScanDirectory(File file, String prefix) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    ScanDirectory(f, prefix + f.getName() + "/");
                } else {
                    try {
                        Map<String, String> result = GetHash(f, "MD5");
                        System.out.println(prefix + f.getName() + " - " + result.get(f.getPath()));
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}