import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_34294_XMLParser_A08 {
    public static void main(String[] args) {
        DefaultHandler handler = new DefaultHandler();
        File xmlFile = new File("yourxmlfile.xml");
        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader(new YourHandler());
            xmlReader.setContentHandler(handler);
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}