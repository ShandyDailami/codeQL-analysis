import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_04014_XMLParser_A08 {

    public static void main(String[] args) {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null);

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(true); // Required for Namespaces
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            File inputFile = new File("input.xml");
            Document document = documentBuilder.parse(inputFile);

            // Get all the 'item' nodes
            NodeList nodeList = document.getElementsByTagName("item");

            // Start processing the 'item' nodes
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Get the current 'item' node
                org.w3c.dom.Element itemElement = (org.w3c.dom.Element) nodeList.item(i);

                // Get the value of the 'item' node
                String itemValue = itemElement.getFirstChild().getNodeValue();
                System.out.println("Item Value: " + itemValue);
            }

        } catch (SAXException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}