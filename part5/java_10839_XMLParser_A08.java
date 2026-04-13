import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.apache.xml.security.utils.SecurityUtils;

public class java_10839_XMLParser_A08 {

    public static void main(String[] args) {
        String fileName = "sample.xml";
        parseXMLFile(fileName);
    }

    private static void parseXMLFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new File(fileName));
            doc.getDocumentElement().normalize();

            // Get the SHA-256 hash of the XML file
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            FileInputStream fis = new FileInputStream(fileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            byte[] digest = md.digest();
            StringBuilder hash = new StringBuilder();
            for (byte b : digest) {
                hash.append(String.format("%02x", b));
            }

            // Use the SHA-256 hash to check the integrity of the XML file
            String expectedHash = "A08_IntegrityFailure";
            if (hash.toString().equals(expectedHash)) {
                System.out.println("XML file is secure with integrity check");
            } else {
                System.out.println("XML file is not secure");
            }

            // Retrieve the XML file's root element
            NodeList nodeList = doc.getElementsByTagName("*");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Node " + (i + 1) + ": " + nodeList.item(i).getNodeName());
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}