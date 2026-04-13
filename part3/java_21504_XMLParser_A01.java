import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

public class java_21504_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml"); // your XML file path

        // Create a DocumentBuilderFactory and use it to create a DocumentBuilder
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        // Use the Builder's build method to parse the XML file
        Document doc = dBuilder.build(new StreamSource(inputFile));

        // Use the Document object to extract information about XML elements
        NodeList nodeList = doc.getElementsByTagName("element"); // replace "element" with the name of the element you want to extract

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Element " + (i + 1) + ": " + nodeList.item(i).getTextContent()); // prints the content of each element
        }
    }
}