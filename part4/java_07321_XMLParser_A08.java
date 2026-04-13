import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import java.io.File;
import java.io.IOException;

public class java_07321_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(new DefaultHandler());

        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        File xmlFile = new File("src/main/resources/test.xml");
        try {
            saxParser.parse(xmlFile, new SAXHandler(xmlReader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        private XMLReader xmlReader;

        public java_07321_XMLParser_A08(XMLReader xmlReader) {
            this.xmlReader = xmlReader;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAIXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAIXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAIXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}