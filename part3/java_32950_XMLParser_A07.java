import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_32950_XMLParser_A07 {

    public void parse(String filePath) {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(xmlFile);

            // Here you would handle the document, e.g., perform security checks
            // For simplicity, we'll just print the XML to the console for now
            doc.getElementsByTagName("xml").item(0).getFirstChild().normalize();
            System.out.println(doc.getElementsByTagName("xml").item(0).getFirstChild().getNodeValue());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        parser.parse("path_to_your_xml_file");
    }
}