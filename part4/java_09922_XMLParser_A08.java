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

public class java_09922_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Read the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Fetch the root element
            doc.getDocumentElement().normalize();

            // Fetch all the 'item' elements
            NodeList nList = doc.getElementsByTagName("item");

            // Iterate through each 'item' element
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nUnique item number: " + (temp + 1));
                System.out.println("Item name: " + nNode.getTextContent());
            }

            // Create a transformer factory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            // Create a transformer
            Transformer transformer = transformerFactory.newTransformer();

            // Prepare the DOM Source
            DOMSource domSource = new DOMSource(doc);

            // Create a Stream Result
            StreamResult streamResult = new StreamResult(System.out);

            // Convert and print the XML file
            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}