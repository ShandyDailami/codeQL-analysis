import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import javax.xml.parsers.ParseException;
import java.io.File;
import java.io.IOException;

public class java_39540_XMLParser_A07 extends DefaultHandler {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File("src/test.xml"), this);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() {
        System.out.println("Parsing a document...");
    }

    @Override
    public void endDocument() {
        System.out.println("Finished parsing the document.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Starting element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("Ending element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Text: " + new String(ch, start, length));
    }
}