import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_36692_XMLParser_A01 {
    private static final String XML_FILE_PATH = "path/to/your/xml/file.xml";

    public static void main(String[] args) {
        try {
            File xmlFile = new File(XML_FILE_PATH);
            InputStream inputStream = new FileInputStream(xmlFile);
            parseXml(inputStream);
        } catch (Exception e) {
            System.out.println("Failed to parse XML: " + e.getMessage());
        }
    }

    private static void parseXml(InputStream inputStream) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse(inputStream);

        // You can now use the document as per your requirement for security sensitive operations
        // For example, you can find the name of the first person in the document:
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("person");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            String name = element.getElementsByTagName("name").item(0).getTextContent();
            System.out.println("Name: " + name);
        }
    }
}