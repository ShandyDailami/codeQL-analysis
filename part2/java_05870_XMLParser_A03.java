import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_05870_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("input.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bElement = false;
        String thisElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            bElement = true;
            thisElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bElement = false;
            if(bElement) {
                System.out.println("End Element: " + thisElement);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElement) {
                System.out.println("Character data: " + new String(ch, start, length));
            }
        }
    }
}