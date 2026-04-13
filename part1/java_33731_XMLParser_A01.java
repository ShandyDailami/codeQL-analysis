import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_33731_XMLParser_A01 {
    private static class MyHandler extends DefaultHandler {
        private boolean tagNameFound = false;
        private String tagName = "";
        private String tagContent = "";

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            tagName = qName;
            tagNameFound = true;
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (tagNameFound) {
                tagContent += new String(ch, start, length);
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (tagName.equals(localName)) {
                System.out.println(tagName + " : " + tagContent);
                tagNameFound = false;
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(false);
        MyHandler myHandler = new MyHandler();
        try {
            saxParser.parse(new File("src/main/resources/data.xml"), myHandler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}