import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_10110_XMLParser_A01 {

    public static void main(String[] args) {
        // create an instance of DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // get a builder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // create an instance of XMLReader
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // start parsing
            reader.setValidation(true);
            reader.setEntityResolver(new CustomEntityResolver());

            try {
                doc.getDocumentElement().normalize();
                System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}