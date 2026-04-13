import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_42090_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try (InputStream inputStream = new FileInputStream("sample.xml")) {
            SAXParser saxParser = factory.newSAXParser(inputStream);

            saxParser.parse(inputStream, new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // This method is called when an element is started
            System.out.println("Start of " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // This method is called when an element is ended
            System.out.println("End of " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // This method is called when characters are found
            String value = new String(ch, start, length).trim();
            if (!value.isEmpty()) {
                System.out.println("Character data: " + value);
            }
        }
    }
}