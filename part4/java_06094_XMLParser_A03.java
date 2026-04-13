import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_06094_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            parseXMLFile("test.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXMLFile(String fileName) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(new File(fileName));
        doc.getDocumentElement().normalize();

        NodeList nodes = doc.getElementsByTagName("secure");

        for (int i = 0; i < nodes.getLength(); i++) {
            String secureData = nodes.item(i).getTextContent();
            System.out.println("Secure data: " + secureData);

            // Here we're using a SHA-256 hash function to hash the secure data
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(secureData.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", b));
            }
            System.out.println("Hash: " + hexString.toString());
        }
    }
}