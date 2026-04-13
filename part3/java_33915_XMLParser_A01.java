import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.elements.DefaultHandler;
import org.xml.sax.helpers.DefaultHandlerContent;

public class java_33915_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");  // replace with your xml file
            XMLReader reader = XMLReaderFactory.createXMLReader();

            DefaultHandlerContent defaultHandler = new DefaultHandlerContent();
            defaultHandler.startDocument();
            defaultHandler.startElement("", "root", "http://www.example.com/root", null);

            reader.setContentHandler(defaultHandler);
            reader.parse(xmlFile);

            defaultHandler.endDocument();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}