import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_28284_XMLParser_A03 {
    private DefaultHandler defaultHandler;

    private class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("student")) {
                return;
            }
            switch (localName) {
            case "name":
                bName = true;
                break;
            case "age":
                bAge = true;
                break;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                // Process the name here.
                bName = false;
            } else if (bAge) {
                // Process the age here.
                bAge = false;
            }
        }
    }

    public void parse(String fileName) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new FileInputStream(fileName), myHandler);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CustomXMLParser parser = new CustomXMLParser();
        parser.parse("students.xml");
    }
}