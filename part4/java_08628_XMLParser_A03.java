import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_08628_XMLParser_A03 {
    public static void main(String[] args) {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a DocumentBuilder with the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file into a Document
            Document document = builder.parse(new File("input.xml"));

            // Transform the content into an indented, readable PrettyXML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(System.out));

            // Now, you can manipulate your XML document here. For example, let's remove an element
            Element rootElement = document.getDocumentElement();
            rootElement.getChildNodes().item(0).getChildNodes().item(0).getNodeValue();
            rootElement.getChildNodes().item(0).getChildNodes().removeChild(rootElement.getChildNodes().item(0).getChildNodes().item(0));

            // Write the modified Document back to the file
            transformer.setOutputProperty("{http://xml.apache.org/xsl/transform/'}indent-amount", "2");
            transformer.transform(new DOMSource(document), new StreamResult(new File("output.xml")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}