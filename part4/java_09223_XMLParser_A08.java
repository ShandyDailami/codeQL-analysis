import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_09223_XMLParser_A08 {
    public static void main(String[] args) {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend.</body>\n" +
                "</note>";

        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);

            MyHandler mh = new MyHandler();
            sp.parse(mh, xml.getBytes("UTF-8"));

            System.out.println("Parsed XML successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bTo = false;
        boolean bFrom = false;
        boolean bHeading = false;
        boolean bBody = false;

        String strTo = null;
        String strFrom = null;
        String strHeading = null;
        String strBody = null;

        @Override
        public void startDocument() {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() {
            System.out.println("End document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("note")) {
                return;
            } else if (qName.equalsIgnoreCase("to")) {
                bTo = true;
            } else if (qName.equalsIgnoreCase("from")) {
                bFrom = true;
            } else if (qName.equalsIgnoreCase("heading")) {
                bHeading = true;
            } else if (qName.equalsIgnoreCase("body")) {
                bBody = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("note")) {
                System.out.println("To: " + strTo);
                System.out.println("From: " + strFrom);
                System.out.println("Heading: " + strHeading);
                System.out.println("Body: " + strBody);
                return;
            }

            if (bTo) {
                bTo = false;
                strTo = qName;
            } else if (bFrom) {
                bFrom = false;
                strFrom = qName;
            } else if (bHeading) {
                bHeading = false;
                strHeading = qName;
            } else if (bBody) {
                bBody = false;
                strBody = qName;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTo || bFrom || bHeading || bBody) {
                String data = new String(ch, start, length);
                if (bTo) {
                    strTo = data.trim();
                } else if (bFrom) {
                    strFrom = data.trim();
                } else if (bHeading) {
                    strHeading = data.trim();
                } else if (bBody) {
                    strBody = data.trim();
                }
            }
        }
    }
}