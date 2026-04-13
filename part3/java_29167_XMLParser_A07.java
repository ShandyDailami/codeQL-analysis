import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_29167_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Get the list of elements in the file
            NodeList nList = doc.getElementsByTagName("*");

            // Traverse through each element in the file
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Element: " + eElement.getNodeName());
                    System.out.println("Value: " + eElement.getTextContent());
                }
            }

            // Close the document
            doc.getDocumentElement().normalize();
            dBuilder.detachDocument();
            dbFactory.invalidate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}