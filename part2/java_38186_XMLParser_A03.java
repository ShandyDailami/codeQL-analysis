import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_38186_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private StringBuilder currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            currentElement = new StringBuilder(localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println(currentElement.toString() + ": " + (qName));
            currentElement = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            currentElement.append(new String(ch, start, length));
        }
    }
}