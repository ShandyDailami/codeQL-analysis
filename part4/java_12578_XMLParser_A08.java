import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_12578_XMLParser_A08 {

    public static void main(String[] args) {
        String fileName = "resources/test.xml";  // replace with your file name
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();

            MyHandler handler = new MyHandler();
            saxParser.parse(new File(fileName), handler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private StringBuilder elementData;
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            currentElement = qName;
            elementData = new StringBuilder();
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            elementData.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (currentElement.equalsIgnoreCase("element")) {
                System.out.println("Element: " + currentElement + ", Data: " + elementData.toString());
            } else {
                System.out.println("Unexpected element: " + currentElement);
            }
        }
    }
}