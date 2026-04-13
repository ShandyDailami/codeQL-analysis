import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_34413_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "document.xml"; // path to XML file
        parseDocument(xmlFile);
    }

    private static void parseDocument(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            // process the document here, for example, print all element names
            printElementNames(document);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElementNames(Document document) {
        Element rootElement = document.getDocumentElement();
        System.out.println("Root element: " + rootElement.getNodeName());

        NodeList childNodes = rootElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Child element: " + element.getNodeName());
            }
        }
    }
}