import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_09282_XMLParser_A07 {

    public static void main(String[] args) {
        String filePath = "/path/to/your/xml/file.xml";
        handleXmlFile(filePath);
    }

    public static void handleXmlFile(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(filePath));

            // Handle the document here
            // For example, print out all element names and their attributes
            document.getElementsByTagName("*").forEach(node -> {
                System.out.println("Tag: " + node.getTagName());
                node.getAttributes().forEach(attr -> {
                    System.out.println("Attr: " + attr.getNodeName() + "=" + attr.getValue());
                });
            });
        } catch (Exception e) {
            System.out.println("Error handling XML file: " + e.getMessage());
       
        }
    }
}