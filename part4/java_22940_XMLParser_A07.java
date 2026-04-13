import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_22940_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            printElementAndAttributes(doc.getDocumentElement());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElementAndAttributes(org.w3c.dom.Element element) {
        if (element.hasChildNodes()) {
            for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                if (element.getChildNodes().item(i).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    org.w3c.dom.Element childElement = (org.w3c.dom.Element) element.getChildNodes().item(i);
                    System.out.println("Element: " + childElement.getNodeName());
                    printElementAndAttributes(childElement);
                } else {
                    System.out.println("Attribute: " + element.getAttributes().item(i).getNodeName() + " = " + element.getAttributes().item(i).getTextContent());
                }
            }
        }
    }
}