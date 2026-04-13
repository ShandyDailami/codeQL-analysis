import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class java_31484_XMLParser_A07 {
    public static void main(String[] args) throws Exception {
        String xml = "<root>Secure XML</root>";
        byte[] bytes = "MySecurePassword".getBytes(StandardCharsets.UTF_8);
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(bytes);
        byte[] digest = md.digest();
        
        String securePassword = new String(digest, StandardCharsets.UTF_8);
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document doc = builder.parse(new InputSource(new StringReader(xml)));
        doc.normalize();
        
        System.out.println("Parsed XML: " + doc.getElementsByTagName("root").item(0).getTextContent());
        System.out.println("Secure password: " + securePassword);
    }
}