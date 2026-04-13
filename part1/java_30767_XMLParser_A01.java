import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_30767_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document doc = builder.parse(new File("sample.xml"));

            // Get all the elements
            NodeList nodes = doc.getElementsByTagName("student");

            // Iterate over the list of students
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element element = (Element) node;

                // Extract the student's name and grade
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String grade = element.getElementsByTagName("grade").item(0).getTextContent();

                System.out.println("Name: " + name);
                System.out.println("Grade: " + grade);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}