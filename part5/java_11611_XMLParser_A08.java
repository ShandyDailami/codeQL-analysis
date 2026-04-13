import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_11611_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/file.xml");
        parseFile(xmlFile);
    }

    public static void parseFile(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc;
        try {
            doc = builder.parse(xmlFile);

            // If the XML is not well-formed, parse() method will throw an exception
            // This is not a security-sensitive operation

            // You can start processing the document here

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}