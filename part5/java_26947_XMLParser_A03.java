import java.io.File;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XercesDOMParser;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.ElementListener;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_26947_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(new File("example.xml"));

        parser.setXMLReader(new SAXHelper(new DefaultHandler()));
        parser.setEntityResolver(new MyEntityResolver());

        parser.parse("example.xml", new MyHandler());
    }

    static class MyHandler extends DefaultHandler {
        public void startDocument() throws SAXException {
            System.out.println("Start document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    static class MyEntityResolver implements javax.xml.entity.EntityResolver {
        public Object getEntity(String entityName, String attrName, String namespaceURI, int notationName) throws SAXException {
            System.out.println("Entity: " + entityName);
            return null;
        }
    }
}