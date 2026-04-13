import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_13444_XMLParser_A08 {
    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));

            Element root = document.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            Element element = (Element) root.getElementsByTagName("element_name").item(0);
            System.out.println("Content of the first occurrence of 'element_name': " + element.getTextContent());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }
}