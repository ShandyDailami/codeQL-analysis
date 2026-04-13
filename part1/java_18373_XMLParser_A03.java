import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_18373_XMLParser_A03 {

    public static void main(String[] args) {

        String xmlFile = "resources/example.xml"; // path to your xml file

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;

        try {
            document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Element root = document.getDocumentElement();
        printElement(root);
    }

    private static void printElement(Element element) {
        System.out.println("- " + element.getNodeName() + " (" + element.getNodeValue() + ")");

        // iterate through children
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            Element child = (Element) element.getChildNodes().item(i);
            printElement(child);
        }
    }
}