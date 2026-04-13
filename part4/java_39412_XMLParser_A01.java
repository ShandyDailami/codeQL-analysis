import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_39412_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean isInElement = false;
        String currentElement = "";
        String currentElementContent = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isInElement = true;
            currentElement = qName;
            currentElementContent = "";
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (isInElement) {
                currentElementContent += new String(chars, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentElement.equals("secureElement")) {
                // Security-sensitive operation: validate if the content is correct
                if (!isContentValid(currentElementContent)) {
                    System.out.println("Broken access control detected in element: " + currentElementContent);
                }
            }
            isInElement = false;
        }

        private boolean isContentValid(String content) {
            // Implement your security-sensitive operations here
            // For simplicity, we just return true for all content
            return true;
        }
    }
}