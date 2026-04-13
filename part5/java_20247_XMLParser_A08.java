import org.jdom2.*;
import org.jdom2.input.*;

public class java_20247_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Parse the XML document
            Document document = loadXMLDocument("input.xml");

            // Print out each element and its attributes
            printElements(document);
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
    }

    private static Document loadXMLDocument(String filename) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(filename);
        return document;
    }

    private static void printElements(Document document) {
        Element root = document.getRootElement();
        printElement(root);
    }

    private static void printElement(Element element) {
        System.out.println("Element: " + element.getName());
        System.out.println("Attributes: " + element.getAttributes().toString());
        for (Element child : element.getChildren()) {
            printElement(child);
        }
    }
}