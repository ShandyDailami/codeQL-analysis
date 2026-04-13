import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_39665_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";
        File file = new File(xmlFile);
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ContentHandler());
            reader.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}