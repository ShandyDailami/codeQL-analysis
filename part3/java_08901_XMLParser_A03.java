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

public class java_08901_XMLParser_A03 {

    public static void main(String[] args) {
        // Create DocumentBuilderFactory and DocumentBuilder instances
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file
        Document document = builder.parse(new File("input.xml"));

        // Get all 'name' and 'age' tags
        NodeList nameList = document.getElementsByTagName("name");
        NodeList ageList = document.getElementsByTagName("age");

        // Print each 'name' and 'age' tag's value
        for (int i = 0; i < nameList.getLength(); i++) {
            System.out.println("Name: " + nameList.item(i).getTextContent());
            System.out.println("Age: " + ageList.item(i).getTextContent());
        }

        // Remove the tags from the XML file
        document.getElementsByTagName("name").item(0).remove();
        document.getElementsByTagName("age").item(0).remove();

        // Transform the modified document back into a string
        String xml = document.getDocumentElement().getTagName();

        // Save the modified XML file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("output.xml"));
        transformer.transform(source, result);
    }
}