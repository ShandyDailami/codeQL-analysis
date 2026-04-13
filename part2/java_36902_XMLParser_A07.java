import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_36902_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Step 1: Set up the DocumentBuilderFactory and DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Parse the XML file
            Document doc = builder.parse(new File("input.xml")); // Replace with your XML file path

            // Step 3: Get the root element and print the element name and value
            Element root = doc.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            // Step 4: Get all element names and print them
            NodeList nodes = doc.getElementsByTagName("*");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element node = (Element) nodes.item(i);
                System.out.println("Element: " + node.getNodeName() + ", Value: " + node.getFirstChild().getNodeValue());
            }

            // Step 5: Write the parsed XML back to an XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("output.xml")); // Replace with your output file path
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}