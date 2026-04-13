import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_33129_XMLParser_A03 {

    private static final String SHA1 = "SHA-1";

    private String hashString(String string) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(SHA1);
            byte[] hash = digest.digest(string.getBytes());
            return org.apache.commons.codec.binary.Hex.encodeHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getSafeHash(String input) {
        String safeHash = hashString(input);
        if (safeHash != null) {
            return safeHash;
        } else {
            return input;
        }
    }

    public void parseXML(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File xmlFile = new File(fileName);
        Document document;

        try {
            document = builder.parse(xmlFile);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println("Failed to parse XML file: " + fileName);
            return;
        }

        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(getSafeHash(nodeList.item(i).getNodeName()));
        }
    }

    public static void main(String[] args) {
        SecureXMLParser parser = new SecureXMLParser();
        parser.parseXML("/path/to/your/xml/file.xml");
    }
}