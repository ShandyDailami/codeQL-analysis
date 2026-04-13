import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_18093_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        System.out.println("File integrity check: " + checkFileIntegrity(file));
    }

    private static String getMD5Hash(File file) {
        String MD5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                md.update(buffer, 0, length);
            }
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            MD5 = sb.toString();
        } catch (NoSuchAlgorithmException | java.io.IOException e) {
            e.printStackTrace();
        }
        return MD5;
    }

    private static boolean checkFileIntegrity(File file) {
        String badMD5 = "A08_IntegrityFailure";
        String fileMD5 = getMD5Hash(file);
        return !fileMD5.equals(badMD5);
    }
}