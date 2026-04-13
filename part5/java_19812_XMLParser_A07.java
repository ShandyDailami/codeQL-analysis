import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_19812_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Get the XML file
            File xmlFile = new File("your_xml_file.xml");

            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(xmlFile);

            // Get all the elements
            NodeList nodeList = doc.getElementsByTagName("*");

            // Print out the names of all the elements
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println(element.getTagName());
                }
            }

            // Create a FileWriter to write the output
            FileWriter writer = new FileWriter("output.txt");
            writer.write("XML Parsed Successfully!");
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}