import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_36322_XMLParser_A07 {
    private static class MyHandler extends DefaultHandler {
        private boolean bAuthFailure = false;

        @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                bAuthFailure = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                bAuthFailure = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bAuthFailure) {
                // Handle the AuthFailure event here
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        try {
            File inputFile = new File("src/main/resources/authfailure.xml");
            parser.parse(inputFile, MyHandler.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}