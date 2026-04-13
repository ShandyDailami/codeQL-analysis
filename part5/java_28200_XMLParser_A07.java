import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLStreamReader;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class java_28200_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream(new File("yourfile.xml"));
            XMLStreamReader xmlsr = XMLStreamReader.newInstance(inputStream);
            SAXHandler handler = new SAXHandler();
            XMLParser parser = new SAXParser(handler);
            parser.parse(xmlsr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class SAXHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}