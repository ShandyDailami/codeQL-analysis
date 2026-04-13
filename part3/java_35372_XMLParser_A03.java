import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_35372_XMLParser_A03 {

    private static final String SHA1 = "SHA-1";

    public static void main(String[] args) {
        String xmlFilePath = "path/to/your/file.xml";
        List<String> hashes = new ArrayList<>();

        try {
            parseFile(xmlFilePath, hashes);
        } catch (SAXException | IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void parseFile(String xmlFilePath, List<String> hashes) throws SAXException, IOException, NoSuchAlgorithmException {
        File xmlFile = new File(xmlFilePath);
        FileInputStream fis = new FileInputStream(xmlFile);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fis);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String elementName = element.getTagName();
            String elementValue = element.getTextContent();

            System.out.println("Element Name: " + elementName);
            System.out.println("Element Value: " + elementValue);

            MessageDigest md = MessageDigest.getInstance(SHA1);
            byte[] array = md.digest(elementValue.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3),
                sb.append(Integer.toHexString(array[i] & 0xFF));
            }
            String hash = sb.toString();

            if (!hashes.contains(hash)) {
                hashes.add(hash);
            }
        }
    }
}