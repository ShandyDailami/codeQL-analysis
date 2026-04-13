import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_35665_XMLParser_A08 {

    public static void main(String[] args) {

        try {
            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get the root element
            NodeList nl = doc.getElementsByTagName("student");

            // Traverse the student nodes
            for (int temp = 0; temp < nl.getLength(); temp++) {
                Node node = nl.item(temp);

                // Extract and output student information
                Element e = (Element) node;
                System.out.print("Name: " + e.getElementsByTagName("name").item(0).getTextContent() + "\n");
                System.out.print("Grade: " + e.getElementsByTagName("grade").item(0).getTextContent() + "\n\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}