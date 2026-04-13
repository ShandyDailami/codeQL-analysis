import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_35171_XMLParser_A08 {

    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file.xml";
        parseXML(filePath);
    }

    private static void parseXML(String filePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(filePath), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private static final String[] tags = { "Book", "Title", "Author", "Price" };

        @Override
        public void startDocument() {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.print("Start Element : " + qName);
            if (isTagPresent(tags, qName)) {
                System.out.println(" with attributes:");
                for (Iterator iter = attributes.getIterator(); iter.hasNext();) {
                    Attribute attribute = (Attribute) iter.next();
                    System.out.println("Attribute: " + attribute.getName() + ", Value: " + attribute.getValue());
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element : " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            System.out.println("Character content: " + content);
        }

        private boolean isTagPresent(String[] tags, String qName) {
            for (String tag : tags) {
                if (tag.equals(qName)) {
                    return true;
                }
            }
            return false;
        }
    }
}