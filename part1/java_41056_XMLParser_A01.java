import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;

public class java_41056_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Step 2: Use DocumentBuilderFactory to create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Step 3: Parse the XML file and create a Document object
            Document doc = dBuilder.parse("src/test.xml");

            // Step 4: Use DOM to traverse the XML file
            // We'll traverse the file by finding all 'book' elements
            NodeList nl = doc.getElementsByTagName("book");

            for (int temp = 0; temp < nl.getLength(); temp++) {
                Node node = nl.item(temp);

                // Extract and print book title
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    System.out.println("Title: " + elem.getElementsByTagName("title").item(0).getTextContent());
                }
            }

            // Step 5: Transform the XML file
            // We'll transform it into an HTML file
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult file = new StreamResult("target/test.html");
            transformer.transform(domSource, file);

            System.out.println("XML file was successfully parsed and transformed!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}