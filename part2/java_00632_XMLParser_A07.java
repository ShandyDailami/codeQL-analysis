import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_00632_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            String xmlFile = "/path/to/your/xml/file.xml";
            File xmlFilePath = new File(xmlFile);
            if (!xmlFilePath.exists()) {
                System.out.println("XML file not found!");
                return;
            }

            // Create a factory for the DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the file into a Document object
            Document doc = builder.parse(xmlFilePath);

            // Use a transformer to transform the Document object into a string
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            // Use a DocumentBuilder to parse the XML file again
            doc = builder.parse(xmlFilePath);

            // Use a DocumentBuilder to iterate over the XML file
            NodeList nodeList = doc.getElementsByTagName("node");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Node " + (i + 1) + ": " + nodeList.item(i).getTextContent());
            }

            // Use a DocumentBuilder to add a new node
            doc.getDocumentElement().normalize();
            doc.getDocumentElement().getChildNodes().item(0).getNodeValue();
            doc.getDocumentElement().appendChild(doc.createElement("newNode"));

            // Use a DocumentBuilder to remove a node
            doc.getDocumentElement().removeChild(doc.getElementsByTagName("newNode").item(0));

            // Use a DocumentBuilder to save the modified XML file
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/path/to/save/xml/file.xml"));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | SAXException | TransformerException | IOException e) {
            e.printStackTrace();
        }
    }
}