import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_25625_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml"); // replace with your xml file
            parseXmlFile(xmlFile);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the XML file.");
            e.printStackTrace();
        }
    }

    public static void parseXmlFile(File xmlFile) throws IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new Source(new FileInputStream(xmlFile)));

        // print out the content of the xml file
        System.out.println("XML Content: " + doc.getDocumentElement().getNodeName());

        // generate a MD5 hash of the xml file content
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(doc.getDocumentElement().getTextContent().getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        System.out.println("MD5 Hash: " + Base64.getEncoder().encodeToString(digest));

        // generate a SHA-256 hash of the xml file content
        md = MessageDigest.getInstance("SHA-256");
        md.update(doc.getDocumentElement().getTextContent().getBytes(StandardCharsets.UTF_8));
        digest = md.digest();
        System.out.println("SHA-256 Hash: " + Base64.getEncoder().encodeToString(digest));
    }
}