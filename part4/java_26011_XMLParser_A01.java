import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_26011_XMLParser_A01 extends DefaultHandler {
    boolean bElement = false;
    String strElement = "";

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            SAXSource saxSource = new SAXSource(new MyXMLParser(), "UTF-8" );
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(saxSource);

            xmlReader.parse(new File("example.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        bElement = true;
        strElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;
        strElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement)
            strElement += new String(ch, start, length);
    }
}