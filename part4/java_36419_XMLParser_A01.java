import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_36419_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML file
            Document doc = builder.parse("resources/secure.xml");

            // Print out the content of the XML file
            printDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        org.w3c.dom.Element root = doc.getDocumentElement();
        System.out.println("Root Element: " + root.getNodeName());

        NodeList nList = root.getChildNodes();
        for (int temp = 0; temp != nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("Child Node: " + nNode.getNodeName());
        }
    }
}