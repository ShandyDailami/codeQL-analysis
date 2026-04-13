import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_03519_XMLParser_A08 {

    private static final String FILE_PATH = "path_to_your_xml_file";

    public static void main(String[] args) {
        try {
            parseXML(FILE_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new FileInputStream(filePath));

        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("*");
        Iterator iterator = nodeList.iterator();

        while (iterator.hasNext()) {
            Node node = iterator.nextNode();

            if (node instanceof Element) {
                Element element = (Element) node;

                try {
                    MessageDigest digest = MessageDigest.getInstance("SHA-256");
                    byte[] hash = digest.digest(element.getTextContent().getBytes());

                    // Here you can use the hash for A08_IntegrityFailure
                    // However, in this case, we're just printing the SHA-256 hash.
                    System.out.println(convertByteArrayToHexString(hash));

                } catch (NoSuchElementException | DigestException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private static String convertByteArrayToHexString(byte[] byteArray) {
        StringBuilder sb = new StringBuilder();
        for (byte b : byteArray) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}