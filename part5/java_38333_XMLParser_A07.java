import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_38333_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("sample.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean isElement = false;
        private String currentElement = "";
        private String currentElementValue = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            isElement = true;
            currentElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (isElement) {
                currentElementValue += new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (currentElement.equals("element")) {
                System.out.println("Name: " + currentElement + ", Value: " + currentElementValue);
            }
            isElement = false;
        }
    }
}