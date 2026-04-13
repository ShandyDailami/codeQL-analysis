import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_00333_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("example.xml"), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bNodeFound = false;
        String thisValue = null;

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("node")) {
                bNodeFound = true;
                thisValue = "";
            }
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("node")) {
                System.out.println("Node value: " + thisValue);
            }
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bNodeFound) {
                thisValue = new String(ch, start, length);
            }
        }
    }
}