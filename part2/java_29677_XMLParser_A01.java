import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_29677_XMLParser_A01 {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String xmlFilePath = "path_to_your_xml_file.xml"; // replace with your xml file path
        File file = new File(xmlFilePath);
        FileInputStream fis = new FileInputStream(file);

        byte[] buffer = new byte[1024];
        MessageDigest md = MessageDigest.getInstance("MD5");
        int bytesCount = 0;

        while ((bytesCount = fis.read(buffer)) != -1) {
            md.update(buffer, 0, bytesCount);
        }
        fis.close();

        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }

        System.out.println("MD5 Checksum: " + sb.toString());
    }
}