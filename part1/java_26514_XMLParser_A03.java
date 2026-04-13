import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_26514_XMLParser_A03 {

    public static void parseXml(String filePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File(filePath), myHandler);
    }

    static class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            // Security-sensitive operation: No injection here
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            // Security-sensitive operation: No injection here
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

            // Security-sensitive operation: No injection here
            String str = new String(ch, start, length);
            System.out.println("Characters: " + str);
        }
    }

    public static void main(String[] args) {
        parseXml("src/main/resources/sample.xml");
    }
}