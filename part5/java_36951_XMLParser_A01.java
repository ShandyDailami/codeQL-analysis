import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_36951_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        parser.parse(new File("path/to/your/xml/file.xml"), handler);
    }

    static class MyHandler extends DefaultHandler {

        private boolean bTag = false;
        private String tagData = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            bTag = true;
            tagData = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bTag = false;

            if (bTag) {
                // Here you can add the code for the security-sensitive operation
                System.out.println("Security-sensitive operation: " + tagData);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                tagData = new String(ch, start, length);
            }
        }
    }
}