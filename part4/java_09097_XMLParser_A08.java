import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_09097_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/example.xml";  // Path to your XML file
        parseAndPrint(xmlFile);
    }

    private static void parseAndPrint(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document;
        try {
            document = builder.parse(new File(xmlFile));
            document.getDoctype(); // Throws SAXException if invalid DOCTYPE

            // Print out content of each tag
            printTags(document);

            // Print out XML file in a human-readable format
            printXml(document);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printTags(Document document) {
        NodeList nodes = document.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println("Tag: " + nodes.item(i).getNodeName());
            System.out.println("Content: " + nodes.item(i).getTextContent());
        }
    }

    private static void printXml(Document document) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        // Pretty print XML file
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);
    }
}