import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_20508_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XMLEventHandler());
            File inputFile = new File("input.xml");
            parser.parse(inputFile, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XMLEventHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;
        private boolean bId = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("person".equals(qName)) {
                bName = true;
                bAge = true;
                bId = true;
                System.out.println("Name, Age, ID");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("person".equals(qName)) {
                bName = false;
                bAge = false;
                bId = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.print("Name: ");
                System.out.write(ch, start, length);
                System.out.println();
            } else if (bAge) {
                System.out.print("Age: ");
                System.out.write(ch, start, length);
                System.out.println();
            } else if (bId) {
                System.out.print("ID: ");
                System.out.write(ch, start, length);
                System.out.println();
            }
        }
    }
}