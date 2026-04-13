import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class java_33912_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFilePath = "/path/to/your/xml/file.xml"; // replace with your xml file path
        try {
            parseXMLFile(xmlFilePath);
        } catch (Exception e) {
            System.out.println("Failed to parse XML file: " + e.getMessage());
        }
    }

    private static void parseXMLFile(String xmlFilePath) throws IOException, ParserConfigurationException, SAXException {
        File xmlFile = new File(xmlFilePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);

        Element root = document.getDocumentElement();
        if (root.getNodeName().equals("Security")) {
            handleSecurityNode(root);
        } else {
            System.out.println("Root node is not a 'Security' node. Exiting.");
            return;
        }
    }

    private static void handleSecurityNode(Element node) throws NoSuchAlgorithmException {
        if (node.getNodeName().equals("IntegrityFailure")) {
            if (!isValidIntegrityFailure(node)) {
                System.out.println("IntegrityFailure node is not valid. Exiting.");
                return;
            }
            // handle integrity failure...
        } else {
            System.out.println("Node " + node.getNodeName() + " is not a 'Security' node. Exiting.");
            return;
        }
    }

    private static boolean isValidIntegrityFailure(Element node) throws NoSuchAlgorithmException {
        String expectedHash = node.getAttribute("expectedHash");
        String actualHash = calculateHash(node.getTextContent());

        return Arrays.equals(Base64.decodeBase64(expectedHash), calculateHash(node.getTextContent()));
    }

    private static String calculateHash(String content) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(content.getBytes("UTF-8"));

        return Base64.encodeBase64String(hash);
    }
}