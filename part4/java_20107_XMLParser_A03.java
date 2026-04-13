import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_20107_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a new instance of DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("input.xml"));

            // Get the element we are interested in
            Element element = doc.getElementsByTagName("elementName").item(0);

            // Extract the value of the element
            String value = element.getTextContent();

            System.out.println("The value of the element is: " + value);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}