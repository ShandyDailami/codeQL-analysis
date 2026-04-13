import java.io.File;
import java.io.FileInputStream;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_38605_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            FileInputStream fis = new FileInputStream(inputFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fis);

            String md5 = getMD5Hash(doc);
            System.out.println("MD5 hash: " + md5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getMD5Hash(Document doc) throws DigestException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(doc.toString().getBytes());
        byte bytedata[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytedata.length; i++) {
            sb.append(Integer.toString((bytedata[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}