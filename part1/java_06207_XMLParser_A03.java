import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_06207_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document;

        try {
            document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
            System.out.println("XML file contents: " + document.getDocumentElement().getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
       
        }
    }
}