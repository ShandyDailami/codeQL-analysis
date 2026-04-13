import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_35610_XMLParser_A08 {
    private static final String MD5 = "MD5";

    public static void main(String[] args) {
        String filePath = "/path/to/your/file.xml";
        System.out.println(parseFile(filePath));
    }

    public static String parseFile(String filePath) {
        try {
            File file = new File(filePath);
            InputStream inputStream = new FileInputStream(file);

            if (inputStream.available() > 1048576) { // if the file size exceeds 1MB
                throw new RuntimeException("File size exceeds 1MB limit");
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            // Get the MD5 hash of the file
            MessageDigest md5 = MessageDigest.getInstance(MD5);
            byte[] digest = md5.digest(document.getDocumentElement().getTextContent().getBytes());

            // Return the MD5 hash as a Base64-encoded string
            return Base64.getEncoder().encodeToString(digest);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}