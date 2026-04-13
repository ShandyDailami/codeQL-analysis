import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

public class java_40129_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "example.xml"; // Provide your XML file path
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new StreamSource(xmlFile));
            doc.getDOCTYPE().getPublicId(); // Check if the document is well-formed

            Element root = doc.getDocumentElement();
            String elementValue = getElementValue(root, "elementName"); // Provide the name of the element

            System.out.println("Element value: " + elementValue);

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static String getElementValue(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            return nNode.getTextContent();
        }
        return null;
    }
}