import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_35139_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());

            File xmlFile = new File("src/main/resources/sample.xml");
            saxParser.parse(xmlFile, new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean tagName = false;
        private boolean tagValue = false;
        private String tagValueBuffer = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("tag")) {
                tagName = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (tagName) {
                tagValue = true;
                tagValueBuffer = new String(ch, start, length);
            } else {
                tagValueBuffer += new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("tag")) {
                printTag();
                tagName = false;
                tagValue = false;
                tagValueBuffer = null;
            }
        }

        private void printTag() {
            System.out.println("Tag: " + (tagName ? "exists" : "does not exist"));
            System.out.println("Value: " + (tagValue ? tagValueBuffer : "does not exist"));
        }
    }
}