import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_04139_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFilePath = "your_xml_file_path";
        parseXml(xmlFilePath);
    }

    public static void parseXml(String xmlFilePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        try {
            document = builder.parse(new File(xmlFilePath));
        } catch (Exception e) {
            e.printStackTrace();
       
        }

        document.getDocumentElement().normalize();

        List<String> elements = document.getElementsTagName("element");
        for (int i = 0; i < elements.size(); i++) {
            System.out.println("Element: " + elements.get(i));
        }

    }
}