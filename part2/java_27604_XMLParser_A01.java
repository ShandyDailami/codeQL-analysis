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

public class java_27604_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File xmlFile = new File("your-xml-file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Get the root element
            doc.getDocumentElement().normalize();

            // Print out the value of the first element
            NodeList nList = doc.getElementsByTagName("element");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Element: " + nNode.getNodeName());
                System.out.println("Value: " + nNode.getTextContent());
            }

            // Print out the attributes of the first element
            NodeList attrList = doc.getElementsByTagName("element");
            for (int temp = 0; temp < attrList.getLength(); temp++) {
                Node nNode = attrList.item(temp);
                System.out.println("Attribute: " + nNode.getAttributes().item(0).getNodeName());
                System.out.println("Value: " + nNode.getAttributes().item(0).getTextContent());
            }

            // Print out the child nodes of the first element
            NodeList childNodes = doc.getElementsByTagName("element");
            for (int temp = 0; temp < childNodes.getLength(); temp++) {
                Node nNode = childNodes.item(temp);
                System.out.println("Child Node: " + nNode.getTextContent());
            }

            // Transform the XML file to HTML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}