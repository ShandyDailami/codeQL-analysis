import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_18865_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");
        parseXML(xmlFile);
    }

    public static void parseXML(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Here you can process the document as per your requirements.
            // For instance, if you want to print all the database credentials, you can do it like this:

            document.getElementsByTagName("credentials").item(0)
                .getTextContent();

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}