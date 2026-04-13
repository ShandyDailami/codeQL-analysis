import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.FileResolver;
import java.io.File;
import java.io.IOException;

public class java_27683_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";  // replace with your XML file
        parse(xmlFile);
    }

    private static void parse(String xmlFile) {
        File xml = new File(xmlFile);
        FileResolver resolver = new FileResolver(xml);
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(resolver);
            MyContentHandler handler = new MyContentHandler();
            reader.setContentHandler(handler);
            reader.parse(xml.toURI().toString());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}