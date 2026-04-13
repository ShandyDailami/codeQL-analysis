import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_04398_XMLParser_A03 {

    public static void main(String[] args) {
        String fileName = "resources/sample.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File(fileName), true);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean tagName = false;
        private boolean tagContent = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equalsIgnoreCase("tag")) {
                tagName = true;
                tagContent = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (tagName) {
                System.out.println(new String(ch, start, length));
                tagName = false;
                tagContent = true;
            }
        }
    }
}