import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_02284_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and use it to create a document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("input.xml"));

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Find and print all elements with name "node"
            NodeList nList = doc.getElementsByTagName("node");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element element = (Element) nList.item(temp);
                // Add your security-sensitive operations here.
                // For example, check the 'name' attribute for 'node' elements.
                String name = element.getAttribute("name");
                if (name.equals("authFailure")) {
                    System.out.println("Found an 'authFailure' element: " + name);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}