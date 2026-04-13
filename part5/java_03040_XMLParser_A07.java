import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

public class java_03040_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML document
            URL url = new URL("http://example.com/sample.xml");
            InputStream input = url.openStream();
            Document doc = builder.parse(input);

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get all the child elements
            NodeList nodes = root.getChildNodes();

            // Loop through all the child nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                Element node = (Element) nodes.item(i);

                // Get the name and value of the node
                String name = node.getNodeName();
                String value = node.getFirstChild().getNodeValue();

                // Print the node
                System.out.println(name + ": " + value);

                // Example of security-sensitive operation
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(value.getBytes(StandardCharsets.UTF_8));
                byte[] digest = md.digest();
                System.out.println("MD5 digest: " + bytesToHex(digest));
            }

            // Close the input stream
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}