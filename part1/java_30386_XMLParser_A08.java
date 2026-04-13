import java.io.File;
import java.util.List;
import java.util.Map;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ElementListener;
import org.xml.sax.XMLReader;

public class java_30386_XMLParser_A08 extends DefaultHandler {

    private Listener listener;
    private XMLReader reader;

    public java_30386_XMLParser_A08(Listener listener) {
        this.listener = listener;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(this);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void parse(String fileName) {
        try {
            reader.parse(new File(fileName));
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Map attributes) {
        listener.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        listener.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        listener.characters(ch, start, length);
    }

    public interface Listener {
        void startElement(String uri, String localName, String qName, Map attributes);
        void endElement(String uri, String localName, String qName);
        void characters(char[] ch, int start, int length);
    }
}