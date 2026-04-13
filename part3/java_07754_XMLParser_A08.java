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

public class java_07754_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "example.xml"; // Path to your XML file
        parseXmlFile(xmlFile);
    }

    private static void parseXmlFile(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(new File(xmlFile));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return;
        }

        document.getDoctype(); // security operation
        // Here, we're making use of a SAXParser, which is a simpler version of XMLParser.

        // Start transforming the document
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Write the result to file
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("output.xml"));

        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
            return;
        }

        // print all the nodes in the document
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Node " + (i + 1) + " : " + nodeList.item(i).getNodeName());
        }
    }
}