import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_27855_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Step 1: Setup the DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Step 2: Parse the XML file
            Document doc = dBuilder.parse(new File("example.xml"));

            // Step 3: Extract and print the data
            NodeList nList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Print the name and value of the element
                    System.out.println("Student Name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Student Age: " + eElement.getElementsByTagName("age").item(0).getTextContent());
                    System.out.println("Student Id: " + eElement.getElementsByTagName("id").item(0).getTextContent());
                }
            }

            // Step 4: Create a new XML file with only the element 'student'
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("output.xml"));
            transformer.transform(source, result);

            System.out.println("XML File has been transformed into output.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}