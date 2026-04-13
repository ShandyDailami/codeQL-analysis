import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_39862_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();

            saxParser.parse(new File("sample.xml"), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder stringBuilder;
        private boolean name;
        private boolean number;

        @Override
        public void startDocument() throws SAXException {
            stringBuilder = new StringBuilder();
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println(stringBuilder.toString());
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            stringBuilder.append("<").append(qName).append(">");
            name = true;
            number = false;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            stringBuilder.append("</").append(qName).append(">");
            name = false;
            number = true;
       
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (name) {
                stringBuilder.append(new String(ch, start, length));
            }
        }
    }
}