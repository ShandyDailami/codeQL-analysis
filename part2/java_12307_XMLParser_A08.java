import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_12307_XMLParser_A08 {

    public static void main(String[] args) throws Exception {
        // Load the XML file
        File file = new File("path/to/xml/file.xml");
        InputStream inputStream = new FileInputStream(file);

        // Parse the XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputStream);

        // Get the integrity failure event
        String integrityFailure = doc.getElementsByTagName("IntegrityFailure").item(0).getTextContent();

        // Hash the integrity failure event
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(integrityFailure.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", b));
        }

        // Print the hashed integrity failure event
        System.out.println("Hashed integrity failure event: " + hexString.toString());
    }
}