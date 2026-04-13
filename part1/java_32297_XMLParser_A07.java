import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_32297_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory and use it to create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Step 3: Get all the child nodes of the document
            NodeList nodeList = doc.getElementsByTagName("student");

            // Step 4: Iterate over all the child nodes and print the information
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;

                // Extract information and print
                String id = element.getAttribute("id");
                String name = element.getAttribute("name");
                String age = element.getAttribute("age");

                System.out.println("Student ID: " + id);
                System.out.println("Student Name: " + name);
                System.out.println("Student Age: " + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}