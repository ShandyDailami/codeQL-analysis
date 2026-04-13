import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_35870_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader xmlReader = null;
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // Enable input
            xmlReader = saxParser.getXMLReader();

            MyHandler myHandler = new MyHandler();
            xmlReader.setContentHandler(myHandler);
            xmlReader.parse(xmlFile);

            System.out.println("Tag: " + myHandler.getTag());
            System.out.println("Data: " + myHandler.getData());
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private String tag;
        private String data;

        public String getTag() {
            return tag;
        }

        public String getData() {
            return data;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            tag = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            data = new String(ch, start, length);
        }
    }
}