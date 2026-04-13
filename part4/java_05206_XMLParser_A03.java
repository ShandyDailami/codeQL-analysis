import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_05206_XMLParser_A03 {
    private static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            if ("person".equals(qName)) {
                bName = true;
                bAge = true;
            } else if (bName) {
                bName = false;
                if ("name".equals(localName)) {
                    System.out.println("Name: " + attributes.getValue(""));
                } else if ("age".equals(localName)) {
                    System.out.println("Age: " + attributes.getValue(""));
                }
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(new File("src/main/resources/people.xml"), handler);
    }
}