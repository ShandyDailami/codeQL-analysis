import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_15178_XMLParser_A03 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("sample.xml"));

            // Get the list of 'person' elements
            NodeList nl = doc.getElementsByTagName("person");

            // Loop through each 'person' element
            for (int temp = 0; temp < nl.getLength(); temp++) {
                Element element = (Element) nl.item(temp);

                // Extract the 'name' and 'age' values
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String age = element.getElementsByTagName("age").item(0).getTextContent();

                // Print the values
                System.out.println("Name: " + name + ", Age: " + age);
           
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}