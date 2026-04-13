import com.sun.org.apache.xpath.internal.dom.NodeListImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_38744_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get all the 'item' elements in the document
            NodeList items = doc.getElementsByTagName("item");

            // Iterate over each 'item' element
            for (int i = 0; i < items.getLength(); i++) {
                Element itemElement = (Element) items.item(i);

                // Get the text content of each 'item' element
                String itemText = itemElement.getTextContent();
                System.out.println("Item " + (i + 1) + ": " + itemText);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}