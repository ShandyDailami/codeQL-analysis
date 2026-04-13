import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_23554_XMLParser_A07 {

    public static void parseFile(String filePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(filePath), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean isAuthorElementFound = false;
        private boolean isTitleElementFound = false;
        private boolean isContentElementFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("author")) {
                isAuthorElementFound = true;
            } else if (qName.equalsIgnoreCase("title")) {
                isTitleElementFound = true;
            } else if (qName.equalsIgnoreCase("content")) {
                isContentElementFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("author")) {
                if (!isAuthorElementFound) {
                    System.out.println("Author element not found!");
                }
                isAuthorElementFound = false;
            } else if (qName.equalsIgnoreCase("title")) {
                if (!isTitleElementFound) {
                    System.out.println("Title element not found!");
                }
                isTitleElementFound = false;
            } else if (qName.equalsIgnoreCase("content")) {
                if (!isContentElementFound) {
                    System.out.println("Content element not found!");
                }
                isContentElementFound = false;
            }
        }
    }

    public static void main(String[] args) {
        parseFile("sample.xml");
    }
}