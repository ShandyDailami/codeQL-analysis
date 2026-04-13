import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_21908_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File("path_to_your_file.xml"));

            // Create a Transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Set the output
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(System.out);

            // Transform the document
            transformer.transform(source, result);

            // Print the document
            System.out.println(document.getElementsByTagName("tag").item(0).getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}