import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.event.SAXEvent;
import org.xml.sax.type.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_07444_XMLParser_A03 {

    public static void parse(String fileName) {
        File inputFile = new File(fileName);
        XMLReader xmlReader = null;
        DefaultHandler defaultHandler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                // Do nothing
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                // Do nothing
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                // Do nothing
            }
        };

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(defaultHandler);
            xmlReader.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}