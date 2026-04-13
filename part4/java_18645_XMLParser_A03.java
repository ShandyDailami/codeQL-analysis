import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_18645_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            printElement(doc.getDocumentElement());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element elem) {
        System.out.println("Element name: " + elem.getNodeName());
        System.out.println("Element text: " + elem.getTextContent());

        for (int i = 0; i < elem.getChildNodes().getLength(); i++) {
            Node node = elem.getChildNodes().item(i);
            if (node.getNodeType() == Node.TEXT_NODE && node.getTextNode().getNodeValue().trim().equals("")) {
                continue;
            } else if (node.getNodeType() == Node.ELEMENT_NODE) {
                printElement((Element) node);
            }
        }
    }
}