import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_28203_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            parseXML("example.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String fileName) throws SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(fileName));

        // Remove the following line if you don't need to hash the content.
        // HashContent(document);

        Iterator itr = document.getElementsByTagName("");
        while (itr.hasNext()) {
            NodeList nlist = (NodeList) itr.next();
            for (int temp = 0; temp < nlist.getLength(); temp++) {
                // Your code here.
            }
        }
    }

    // This method will be used to hash the content of the document
    private static void HashContent(Document doc) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return;
        }

        try {
            byte[] bytearray = doc.getBytes("UTF-8");
            md.update(bytearray);
            byte[] digest = md.digest();
            for (int i = 0; i < digest.length; i++) {
                System.out.println(Integer.toHexString(digest[i]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}