import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_36398_XMLParser_A03 {

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        File inputFile = new File("input.xml");
        parser.parse(inputFile, MyHandler.getContext());
    }

    static class MyHandler extends DefaultHandler {

        private static String lastTag = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start of " + qName);
            lastTag = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of " + qName);
            lastTag = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastTag != null && lastTag.length() > 0) {
                System.out.println("In " + lastTag + ": " + new String(ch, start, length));
            }
        }
    }
}