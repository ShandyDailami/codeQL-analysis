import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_01319_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();

        try {
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File("myfile.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder data = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            data.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            data.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("myElement".equals(qName)) {
                System.out.println("Data in myElement: " + data.toString());
            }
        }
    }
}