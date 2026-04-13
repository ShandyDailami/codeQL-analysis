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

public class java_21481_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Normalize the Document
            doc.getDocumentElement().normalize();

            // Get the list of elements
            NodeList nodeList = doc.getElementsByTagName("*");

            // Create a TransformerFactory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            // Create a Transformer
            Transformer transformer = transformerFactory.newTransformer();

            // Prepare the output in a DOM-style writer
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);

            // Transform the DOM source to the result
            transformer.transform(source, result);

            // Print each element and its value
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println(nodeList.item(i).getNodeName() + ": " + nodeList.item(i).getTextContent());
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}