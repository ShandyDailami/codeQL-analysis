import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_13716_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            String xmlFile = "yourfile.xml";
            File file = new File(xmlFile);
            if (!file.exists()) {
                System.out.println("File does not exist");
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            String md5Hash = calculateMD5Hash(doc);

            if (!isValidMD5Hash(md5Hash)) {
                System.out.println("Integrity failure detected!");
            } else {
                System.out.println("No integrity failures detected!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String calculateMD5Hash(Document doc) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(doc.toString().getBytes());
            byte[] messageDigest = digest.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xFF & b);
                while (hex.length() < 2) {
                    hex = "0" + hex;
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean isValidMD5Hash(String hash) {
        return hash != null && hash.matches("^[a-fA-F0-9]{32}$");
    }
}