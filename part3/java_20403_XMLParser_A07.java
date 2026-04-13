import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_20403_XMLParser_A07 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean isTagName = false;
        private String currentTagName = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            isTagName = true;
            currentTagName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isTagName = false;
            currentTagName = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTagName) {
                System.out.println(currentTagName + ": " + new String(ch, start, length));
            }
        }
    }
}