import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXParserHelper;

public class java_03925_XMLParser_A08 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParserHelper parser = null;

        try {
            parser = factory.newSAXParserHelper(new FileInputStream(inputFile), true);
            parser.setContentHandler(new MyContentHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            parser.parse();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            System.out.println("Starting document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("Ending document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Starting element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("Ending element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}