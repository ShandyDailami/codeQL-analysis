import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessController;
import java.security.Access;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class java_26902_XMLParser_A01 {
    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            // Step 2: Get DocumentBuilder for parsing the XML file
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Step 3: Use the DocumentBuilder to read the XML file
            InputStream inputStream = new FileInputStream("sample.xml");
            Document doc = dBuilder.parse(inputStream);

            // Step 4: Use the DOM API to traverse the document and print the names of all the elements
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
            traverse(doc.getDocumentElement(), "");

            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void traverse(Element element, String indent) {
        // Step 1: Print current element
        System.out.print(indent + element.getNodeName());

        // Step 2: If current element has child nodes
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            // Step 3: Traverse and print child nodes
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                traverse((Element) children.item(i), indent + "  ");
            }
        }
    }
}