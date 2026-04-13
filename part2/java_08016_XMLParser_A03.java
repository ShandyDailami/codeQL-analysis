import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_08016_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/sample.xml");
        parseXml(xmlFile);
    }

    public static void parseXml(File xmlFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(xmlFile.toURI().toURL());
            MyHandler handler = new MyHandler();
            parser.parse(xmlFile, handler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        @Override
        public void startDocument() {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start of Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}