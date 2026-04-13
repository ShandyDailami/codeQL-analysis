import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_11858_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "src/data.xml";
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(fileName);
            document.getDocumentElement().normalize();

            parseNode(document);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseNode(Document document) {
        // Extract the authfailure node and parse its content
        if (document.getElementsByTagName("authfailure").getLength() > 0) {
            System.out.println("Security failure detected!");
            // You can add code here to handle the security failure
            // For example, you can log the failure, send an alert, etc.
        }

        // Traverse through all the nodes
        for (int i = 0; i < document.getChildNodes().getLength(); i++) {
            Node node = document.getChildNodes().item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                parseNode((Element) node);
            }
        }
    }
}