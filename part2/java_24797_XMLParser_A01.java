import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_24797_XMLParser_A01 {

    public static void main(String[] args) {
        // Step 1: Create DocumentBuilderFactory instance
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Step 2: Create DocumentBuilder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML document
            Document doc = builder.parse("sample.xml");

            // Step 4: Retrieve the root element
            Element root = doc.getDocumentElement();

            // Step 5: Print the node name and attribute value
            printElement(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        System.out.println("Element name: " + element.getNodeName());
        //print attributes
        if (element.hasAttributes()) {
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                System.out.println("Attribute " + i + ": " + element.getAttributes().item(i).getNodeName() + " = " + element.getAttributes().item(i).getTextContent());
            }
        }
        //print children
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i).getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + element.getChildNodes().item(i).getNodeValue());
            } else {
                printElement((Element) element.getChildNodes().item(i));
            }
        }
    }
}