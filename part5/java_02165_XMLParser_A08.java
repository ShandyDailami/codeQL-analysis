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

public class java_02165_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Load XML file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Print all 'item' nodes
            NodeList itemList = doc.getElementsByTagName("item");
            for (int temp = 0; temp < itemList.getLength(); temp++) {
                Element element = (Element) itemList.item(temp);
                System.out.println("Item Name: " + element.getAttribute("name"));
                System.out.println("Item Value: " + element.getAttribute("value"));

                // Print 'item' details
                printElement(element);
            }

            // Create an instance of TransformerFactory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);
            // Use this if you want to write the XML back to a file
            // result = new StreamResult("output.xml");
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to print details of an XML element
    public static void printElement(Element element) {
        System.out.println("Tag Name: " + element.getTagName());
        System.out.println("Attribute Value: " + element.getAttribute("value"));
        System.out.println("Text: " + element.getText());
    }
}