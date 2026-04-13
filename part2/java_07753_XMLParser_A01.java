import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_07753_XMLParser_A01 {
    private static final String FILE_PATH = "path_to_your_xml_file";

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            Handler handler = new Handler();
            saxParser.parse(new File(FILE_PATH), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends DefaultHandler {
        private boolean isAuthorElementFound = false;
        private boolean isContentElementFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("author".equals(qName)) {
                isAuthorElementFound = true;
            } else if ("content".equals(qName)) {
                isContentElementFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("author".equals(qName) && isAuthorElementFound) {
                System.out.println("Access to author element is restricted!");
                isAuthorElementFound = false;
            } else if ("content".equals(qName) && isContentElementFound) {
                System.out.println("Access to content element is restricted!");
                isContentElementFound = false;
            }
        }
    }
}