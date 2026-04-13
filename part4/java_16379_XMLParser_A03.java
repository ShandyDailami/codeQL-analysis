import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.security.CodeSignature;

public class java_16379_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Step 1: Load XML file
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Step 2: Extract specific data
            NodeList nodes = doc.getElementsByTagName("student");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element element = (Element) node;

                // Extract data from "student" element
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String grade = element.getElementsByTagName("grade").item(0).getTextContent();

                // Security-sensitive operation: NoSQL Injection
                // NoSQL Injection is a code injection technique.
                // This example does not show it but in real-world scenarios,
                // the database query can be affected by injection.

                System.out.println("Student name: " + name);
                System.out.println("Student grade: " + grade);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}