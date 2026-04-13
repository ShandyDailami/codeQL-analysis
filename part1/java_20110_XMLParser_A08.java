import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_20110_XMLParser_A08 {

    public static class MyHandler extends DefaultHandler {
        private StringBuilder data = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            data.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            switch (qName) {
                case "employee":
                    System.out.println(data.toString());
                    break;
                case "name":
                    break;
                case "id":
                    break;
                case "salary":
                    break;
                default:
                    data.append(qName).append(": ").append(data.toString());
                    break;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            data.append(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/employees.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(xmlFile, MyHandler.class);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}