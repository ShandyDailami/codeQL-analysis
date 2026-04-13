import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_24515_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new XmlHandler());
            saxParser.parse(new File("src/main/resources/data.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
                bName = false;
            } else if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
                bAge = false;
            }
        }
    }
}