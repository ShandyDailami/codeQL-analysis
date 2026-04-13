import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_19746_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            File xmlFile = new File("path_to_your_file");
            saxParser.parse(xmlFile, null);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;
        private String currentElement = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;

            if (qName.equals("person")) {
                bName = true;
                bAge = true;
            } else {
                if (bName && qName.equals("name")) {
                    bName = false;
                } else if (bName && qName.equals("age")) {
                    bAge = false;
                } else if (!bName && !bAge && qName.equals("person")) {
                    System.out.println("<person>");
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                System.out.println("</" + qName + ">");
            } else if (bName && qName.equals("name")) {
                bName = false;
            } else if (bAge && qName.equals("age")) {
                bAge = false;
            }

            currentElement = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (currentElement != null && bName && bAge) {
                String value = new String(ch, start, length);
                System.out.println("<" + currentElement + ">" + value + "</" + currentElement + ">");
                bName = false;
                bAge = false;
            }
        }
    }
}