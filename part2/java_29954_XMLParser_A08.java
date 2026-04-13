import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_29954_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Load the XML file
            Document doc = builder.parse(new File("path_to_your_file.xml"));
            
            // Get the value of the specific element
            String elementValue = getElementValue(doc, "element_name");
            
            // Write the value to a file
            FileWriter writer = new FileWriter("output.txt");
            writer.write("The value of the element is: " + elementValue);
            writer.close();
            
            System.out.println("The value of the element is: " + elementValue);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getElementValue(Document doc, String elementName) {
        NodeList nodes = doc.getElementsByTagName(elementName);
        return nodes.item(0).getTextContent();
    }
}