import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_34714_XMLParser_A03 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, NoSuchAlgorithmException {
        String xmlFile = "example.xml";

        // Create a new DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Use the factory to create a new DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file into a Document
        Document document = builder.parse(new File(xmlFile));

        // Hash the XML file
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(document.getDocumentElement().getTextContent().getBytes());
        String encrypted = Base64.getEncoder().encodeToString(bytes);

        // Print the encrypted file
        System.out.println("Encrypted XML file: " + encrypted);

        // Now, we can decrypt the file using the same MD5 algorithm
        MessageDigest mdDecrypt = MessageDigest.getInstance("MD5");
        byte[] bytesDecrypt = mdDecrypt.digest(encrypted.getBytes());
        String decrypted = Base64.getEncoder().encodeToString(bytesDecrypt);

        // Print the decrypted file
        System.out.println("Decrypted XML file: " + decrypted);
    }
}