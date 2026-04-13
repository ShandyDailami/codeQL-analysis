import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.XMLConstants;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;

public class java_30797_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Setup the factory
            factory.setValidating(true);
            factory.setNamespaceAware(true);
            
            // Create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load your XML file
            Document doc = builder.parse(new File("example.xml"));

            // Setup some styles
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // Iterate over all element nodes
            NodeList nodes = doc.getElementsByTagName("*");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element el = (Element) nodes.item(i);
                System.out.println("Element: " + el.getNodeName());
                System.out.println("Attributes:");
                for (int j = 0; j < el.getAttributes().getLength(); j++) {
                    System.out.println("Attribute: " + el.getAttributes().item(j).getNodeName() + "=" + el.getAttributes().item(j).getNodeValue());
                }
            }

            // Create a transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

            // Write out the XML file
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}