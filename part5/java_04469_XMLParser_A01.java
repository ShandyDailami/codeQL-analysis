import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_04469_XMLParser_A01 {

    private DefaultHandler defaultHandler;
    private XMLReader reader;

    public java_04469_XMLParser_A01() {
        defaultHandler = new DefaultHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public void parse(String file) {
        reader.setContentHandler(defaultHandler);
        try {
            reader.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("sample.xml");
    }
}