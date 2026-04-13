import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_20412_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // create a factory object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // obtain a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // print out the contents
            System.out.println(doc.getDocumentElement().getNodeName());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}