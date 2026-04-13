import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_14179_XMLParser_A07 {
    public static void main(String[] args) {
        String filePath = "path/to/your/xml/file.xml";
        String tagName = "tagName";
        String attributeName = "attributeName";
        String attributeValue = "attributeValue";

        parseXML(filePath, tagName, attributeName, attributeValue);
    }

    public static void parseXML(String filePath, String tagName, String attributeName, String attributeValue) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new File(filePath));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return;
        }

        doc.getElementsByTagName(tagName);

        NodeList nodes = doc.getElementsByTagName(tagName);
        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getAttributes().getNamedItem(attributeName) != null
                    && nodes.item(i).getAttributes().getNamedItem(attributeName).getTextContent().equals(attributeValue)) {
                System.out.println("Found tag: " + nodes.item(i).getTagName() + " with attribute: " + attributeName);
            }
        }
    }
}