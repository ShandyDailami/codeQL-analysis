import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_28883_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the document
            Document doc = builder.parse("src/data.xml");

            // Extract data from the document
            extractData(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void extractData(Document doc) {
        // Fetch the root element
        doc.getDocumentElement().normalize();

        // Iterate over the nodes
        int nodeCount = doc.getChildNodes().getLength();
        for (int i = 0; i < nodeCount; i++) {
            Node node = doc.getChildNodes().item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element name: " + element.getNodeName());
                System.out.println("Element value: " + element.getFirstChild().getNodeValue());
            }
        }
    }
}