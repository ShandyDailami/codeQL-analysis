import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;

public class java_12753_XMLParser_A03 {

    public static void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true);

            MyHandler handler = new MyHandler();
            saxParser.parse(new StringReader(xml), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bElement = false;
        StringBuilder elementValue = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bElement = true;
            elementValue = new StringBuilder();
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (bElement) {
                bElement = false;
                System.out.println(qName + " : " + elementValue.toString());
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElement) {
                elementValue.append(new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) {
        String xml = "<root><element1>content1</element1><element2>content2</element2></root>";
        parse(xml);
    }
}