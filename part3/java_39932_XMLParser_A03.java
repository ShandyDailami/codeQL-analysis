import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_39932_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();

            saxParser.parse(xmlFile, myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private String lastElement;
        private String lastValue;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElement = qName;
            lastValue = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("record".equals(lastElement)) {
                handleRecord(lastValue);
            } else {
                System.out.println("Unknown element: " + lastElement + ", value: " + lastValue);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            lastValue = new String(ch, start, length);
        }

        private void handleRecord(String value) {
            // Here you can implement a security-sensitive operation.
            // For example, check if the value contains certain keywords or patterns.
            if (value.contains("password")) {
                System.out.println("Detected suspicious entry in the 'password' field");
            }
        }
    }
}