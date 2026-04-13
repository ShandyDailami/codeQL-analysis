import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_19156_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        MyHandler myHandler = new MyHandler();
        saxParser.parse(xmlFile, myHandler);
    }

    private static class MyHandler extends DefaultHandler {

        private boolean isElementName = false;
        private String currentElementName = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isElementName = true;
            currentElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isElementName) {
                System.out.println("Element Name: " + currentElementName);
                isElementName = false;
            }
        }

    }
}