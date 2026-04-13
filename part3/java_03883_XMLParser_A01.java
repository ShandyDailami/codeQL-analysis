import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03883_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse("sample.xml");  // replace with your xml file

            System.out.println("XML Parsing Successful");

        } catch (SAXException | IOException e) {
            System.out.println("Error parsing the XML file");
            e.printStackTrace();
       
        }
    }
}