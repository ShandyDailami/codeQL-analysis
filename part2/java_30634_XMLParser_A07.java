import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_30634_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));
            // Get the root element
            Element root = doc.getDocumentElement();
            // Create a MessageDigest instance for hashing
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(root.toString().getBytes());
            String hash = bytesToHex(md.digest());
            // Check if the hash is the same as the one we expected
            if (hash.equals("A07_AuthFailure")) {
                // If the hash is correct, print out the element and attribute names
                printElementAndAttributes(root);
            } else {
                System.out.println("Hash is incorrect");
            }
        } catch (ParserConfigurationException | IOException | SAXException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void printElementAndAttributes(Element root) {
        // Get the element name and print it
        System.out.println("Element name: " + root.getNodeName());
        // Iterate over all child elements
        Iterator<Element> iterator = root.getChildNodes().iterator();
        while (iterator.hasNext()) {
            Element child = iterator.next();
            // Get the child element name and attribute names
            System.out.println("Child element name: " + child.getNodeName());
            System.out.println("Child element attributes: " + child.getAttributes());
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toHexString((bytes[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }
}