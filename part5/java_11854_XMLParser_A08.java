import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11854_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File("example.xml"), myHandler);
    }

    static class MyHandler extends DefaultHandler {

        private boolean bTag = false;
        private String currentElement = "";
        private String currentAttributeValue = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            bTag = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bTag = false;
            currentElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                String str = new String(ch, start, length);
                if (currentElement.equals("element")) {
                    System.out.println("Value: " + str);
                } else if (currentElement.equals("attribute")) {
                    currentAttributeValue = str;
                }
            }
        }
    }
}