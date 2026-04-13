import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.SAXHelper;

public class java_30157_XMLParser_A08 {

    private static final String SHA1 = "SHA-1";

    private java_30157_XMLParser_A08() {
    }

    public static void main(String[] args) throws Exception {
        String xmlFile = "/path/to/your/xml/file";
        parseXml(xmlFile);
    }

    public static void parseXml(String xmlFile) {
        SAXHelper sax = new SAXHelper();
        sax.setXmlReader(createSaxReader(xmlFile));
        try {
            sax.parse();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static InputStream createSaxReader(String xmlFile) {
        try {
            FileInputStream fis = new FileInputStream(xmlFile);
            return fis;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFileChecksum(InputStream is, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] buffer = new byte[8192];
        int bytesNumRead = 0;
        try {
            while ((bytesNumRead = is.read(buffer)) != -1) {
                md.update(buffer, 0, bytesNumRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bytesToHex(md.digest());
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}