import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_17677_XMLParser_A07 {

    public static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bId = false;
        private String tempValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equalsIgnoreCase("student")) {
                return;
            }

            if (qName.equalsIgnoreCase("name")) {
                bName = true;
                return;
            }

            if (qName.equalsIgnoreCase("id")) {
                bId = true;
                return;
            }

            tempValue = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            if (bName) {
                System.out.println("Name: " + tempValue);
                bName = false;
            }

            if (bId) {
                System.out.println("ID: " + tempValue);
                bId = false;
            }

            tempValue = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

            if (bName || bId) {
                tempValue = new String(ch, start, length);
            }
        }
    }

    public static void main(String[] args) {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            saxParser.parse("src/main/resources/students.xml", new MyHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}