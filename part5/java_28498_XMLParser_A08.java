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

public class java_28498_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the XML document
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Step 2: Extract the information
            NodeList nList = doc.getElementsByTagName("record");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Extract the data
                    String id = eElement.getAttribute("id");
                    String name = eElement.getAttribute("name");
                    String location = eElement.getAttribute("location");

                    // Step 3: Print the information
                    System.out.println("Record ID: " + id);
                    System.out.println("Record Name: " + name);
                    System.out.println("Record Location: " + location);

                    // Step 4: Write the information to another XML file
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File("output.xml"));
                    transformer.transform(source, result);
                }
            }

            // Step 5: Security-sensitive operation (e.g. reading/writing a file)
            // This is a security-sensitive operation, but not shown in this example

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}