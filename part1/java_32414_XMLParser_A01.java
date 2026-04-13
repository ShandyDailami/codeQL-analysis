import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXSource;
import java.io.File;
import java.io.IOException;

public class java_32414_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            File inputFile = new File("input.xml");
            SAXSource source = new SAXSource(parser, inputFile);
            parser.parse(source, true);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class XmlHandler implements javax.xml.parsers.SAXHandler {

        private boolean bName;
        private boolean bAge;
        private String tempValue;

        public java_32414_XMLParser_A01() {
            bName = false;
            bAge = false;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                return;
            }
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
                return;
            }
            if (qName.equalsIgnoreCase("age")) {
                bAge = true;
                return;
            }
            tempValue = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                return;
            }
            if (bName) {
                bName = false;
                System.out.println("Name: " + tempValue);
            }
            if (bAge) {
                bAge = false;
                System.out.println("Age: " + tempValue);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName || bAge) {
                tempValue = new String(ch, start, length);
            }
        }

    }
}