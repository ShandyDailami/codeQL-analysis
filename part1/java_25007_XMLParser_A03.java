import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_25007_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "yourfile.xml";
        parse(xmlFile);
    }

    public static void parse(String xmlFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new FileInputStream(new File(xmlFile)), true);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private static final String NAMESPACE_DECLARATION =
            "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
            "xsi:schemaLocation=\"yourSchema.xsd\"";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start element: " + qName);
            // Here you can add code to parse the content of the elements
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
        }

        @Override
        public void startDocument(String uri, String localName, String version) {
            System.out.println("Start document: " + localName);
        }

        @Override
        public void endDocument(String uri, String localName, String version) {
            System.out.println("End document: " + localName);
        }
    }
}