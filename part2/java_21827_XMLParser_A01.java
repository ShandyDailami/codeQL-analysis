import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_21827_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file.xml";  // Change this to the actual path of your XML file
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(false);

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(xmlFile));

            // Print XML file data
            printDocumentData(doc);

            // Write XML file to another location
            writeDocumentToFile(doc, "/path/to/write/xml/file.xml");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printDocumentData(Document doc) {
        System.out.println("XML File Content:");
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Node " + (i + 1) + ": " + nodeList.item(i).getTextContent());
        }
    }

    private static void writeDocumentToFile(Document doc, String outputFile) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(outputFile));
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}