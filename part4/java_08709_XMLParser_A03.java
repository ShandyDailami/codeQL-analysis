import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_08709_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Get the root element
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getElementsByTagName("").item(0).getNodeName());

            // Find and print all the text in the document
            NodeList nList = doc.getElementsByTagName("*");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                System.out.println("Element : " + nList.item(temp).getNodeName());
                System.out.println("Element content : " + nList.item(temp).getTextContent());
            }

            // Hash the XML content
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] xmlContent = doc.getBytes();
            md.update(xmlContent);
            byte[] digest = md.digest();
            for (int i = 0; i < digest.length; i++) {
                System.out.format("%02x", digest[i]);
            }
            System.out.println();

        } catch (ParserConfigurationException | SAXException | IOException | CertificateException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}