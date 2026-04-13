import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.handlers.DefaultHandler;
import org.xml.sax.parser.XMLParser;

import java.io.File;
import java.io.IOException;

public class java_25299_XMLParser_A03 {

    private static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXParseException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileName = "src/main/resources/example.xml";
        File xmlFile = new File(fileName);

        XMLParser parser = XMLReaderFactory.createXMLParser(
                null,
                new MyHandler(),
                new SAXSource(new FileInputStream(xmlFile))
        );

        try {
            parser.parse(null);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}