import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_22173_XMLParser_A07 {

    public static void parseXML(String filePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(filePath), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean isAuthFailure = false;
        private String currentElement = "";

        @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            if(qName.equals("AuthFailure")) {
                isAuthFailure = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = "";
            if(qName.equals("AuthFailure")) {
                isAuthFailure = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if(isAuthFailure && currentElement.equals("AuthFailure")) {
                System.out.println("Security alert: AuthFailure detected in the XML file!");
            }
        }
    }

    public static void main(String[] args) {
        parseXML("src/test.xml");  // replace with your xml file path
    }
}