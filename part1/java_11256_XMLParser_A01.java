import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11256_XMLParser_A01 {
    private static final String USER = "user";
    private static final String PERMISSION = "permission";
    private static final String READ = "read";

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/accessControl.xml";
        File file = new File(xmlFile);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(file, new MyHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private StringBuilder currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currentElement = new StringBuilder(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentElement.toString().equalsIgnoreCase(USER) &&
                    currentElement.toString().equalsIgnoreCase(PERMISSION)) {
                System.out.println("Permission granted for user " + USER);
            }
        }
    }
}