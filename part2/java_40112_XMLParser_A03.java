import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_40112_XMLParser_A03 {

    private class SaxHandler extends DefaultHandler {

        public void startDocument() {
            System.out.println("Start of document");
        }

        public void endDocument() {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start of element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            System.out.println("Content: " + content);
        }

        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }

    }

    public void parse(String xmlFilePath) throws IOException, SAXException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        SaxHandler saxHandler = new SaxHandler();
        saxParser.parse(new File(xmlFilePath), saxHandler);
    }

}