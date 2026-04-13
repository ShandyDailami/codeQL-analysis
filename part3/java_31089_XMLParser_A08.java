import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_31089_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            File xmlFile = new File("example.xml");
            saxParser.parse(xmlFile, new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("person")) {
                System.out.println("------- Person Details -------");
                bName = true;
                bAge = true;
            } else if (bName && qName.equals("name")) {
                System.out.println("Name: ");
                bName = false;
            } else if (bName && qName.equals("age")) {
                System.out.println("Age: ");
                bAge = false;
            } else if (bAge && qName.equals("age")) {
                System.out.println("Age: ");
                bAge = false;
            } else if (bAge && qName.equals("name")) {
                System.out.println("Name: ");
                bName = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                System.out.println();
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.print(new String(ch, start, length));
            }
            if (bAge) {
                System.out.print(" - Age: " + new String(ch, start, length));
            }
        }
    }
}