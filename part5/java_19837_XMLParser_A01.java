import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_19837_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        parseXML(xmlFile);
    }

    public static void parseXML(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
       .
.
.
.

            // Rest of the code

        }
    }
}