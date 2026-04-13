import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_22244_XMLParser_A07 {
    public static void main(String[] args) {
        String filePath = "path_to_your_file.xml"; // replace with your xml file path

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);

            // print the content of the xml file
            document.getDocumentElement().normalize();
            System.out.println("Root Element : " + document.getDocumentElement().getNodeName());

            System.out.println("XML Parsed Successfully");

        } catch (SAXException e) {
            System.out.println("Error parsing XML : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error loading XML : " + e.getMessage());
        }
    }
}