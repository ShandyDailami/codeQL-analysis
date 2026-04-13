import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_39377_XMLParser_A03 {

    public void parse(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(fileName);

            // Print the XML document elements and attributes
            printDocument(document);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printDocument(Document document) {
        document.getDocumentElement().normalize();
        System.out.println("Root element: " + document.getElements().getItem(0).getNodeName());

        // Get and print all child nodes of the root node
        for (int i = 0; i < document.getElements().getLength(); i++) {
            System.out.println("Child node: " + document.getElements().getItem(i).getNodeName());
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("sample.xml");
    }
}