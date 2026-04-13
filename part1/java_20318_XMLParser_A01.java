import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import java.io.IOException;

public class java_20318_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // load the xml document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // create an instance of the XMLReader
            XMLReader reader = doc.getXMLReader();

            // use a custom handler to process the document
            DefaultHandler handler = new DefaultHandler();
            reader.setContentHandler(handler);

            // start parsing the document
            reader.parse(new org.xml.sax.InputSource(new StringReader(doc.getDocumentElement().getTextContent())));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}