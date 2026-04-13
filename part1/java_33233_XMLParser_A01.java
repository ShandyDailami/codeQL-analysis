import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

public class java_33233_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new DefaultHandler());

            String xmlFile = "src/main/resources/sample.xml";
            reader.parse(xmlFile);

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}