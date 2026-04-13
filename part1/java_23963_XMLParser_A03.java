import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_23963_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";  // replace with your xml file
        parse(xmlFile);
    }

    private static void parse(String xmlFile) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new XMLReader(new StringReader(xmlFile)));

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new InputSource(new File(xmlFile)), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private StringBuilder stringBuilder;

        public java_23963_XMLParser_A03() {
            stringBuilder = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            stringBuilder.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            stringBuilder.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            String xmlText = stringBuilder.toString();
            // do something with the xml text here, e.g. print it to the console
            System.out.println(xmlText);
        }
    }
}