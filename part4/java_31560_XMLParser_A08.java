import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_31560_XMLParser_A08 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // enable validation
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("sample.xml")); // parse XML file

            // print parsed data
            System.out.println(doc.getDocumentElement().getTagName());
            System.out.println(doc.getElementsByTagName("book").item(0).getTextContent());

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}