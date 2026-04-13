import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_21307_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("example.xml"), false);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bValue = false;
        private String tempValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                bName = true;
                bValue = false;
                tempValue = null;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                bName = false;
                tempValue = new String(ch, start, length);
            }
            if (bValue) {
                bValue = false;
                String value = new String(ch, start, length);
                System.out.println("Name: " + tempValue + ", Value: " + value);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                bName = false;
                bValue = true;
            }
        }
    }
}