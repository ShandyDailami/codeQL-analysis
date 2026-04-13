import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_08978_XMLParser_A01 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler(true));
            parser.parse(inputFile, new MyHandler(false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean isInElement = false;
        String currentElement = "";
        String currentValue = "";

        public java_08978_XMLParser_A01(boolean isFirstCall) {
            super();
            if (isFirstCall) {
                System.out.println("Parsing started.");
            }
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isInElement = true;
            currentElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentElement.equals("Student")) {
                System.out.println("Student Name: " + currentValue);
            } else if (currentElement.equals("Grade")) {
                System.out.println("Grade: " + currentValue);
            }
            isInElement = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isInElement) {
                currentValue = new String(ch, start, length);
            }
        }
    }
}