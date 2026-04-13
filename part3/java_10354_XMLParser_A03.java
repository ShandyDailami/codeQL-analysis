import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_10354_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "input.xml";
        File file = new File(xmlFile);

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new DefaultHandler());

            reader.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}