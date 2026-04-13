import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.xml.parsers.DocumentBuilder;
import java.xml.parsers.DocumentBuilderFactory;
import java.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_39619_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("example.xml");
            InputStream inputStream = new FileInputStream(file);

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.parse(inputStream);
            document.getDocumentElement().normalize();

            System.out.println("XML Parsed Successfully");

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}