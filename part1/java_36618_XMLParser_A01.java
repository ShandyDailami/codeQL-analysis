import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_36618_XMLParser_A01 {
    public static void main(String[] args) {
        // Step 1: Parse XML file using SAX
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (SAXParser saxParser = saxParserFactory.newSAXParser(new XMLReaderFactory())) {
            MyHandler myHandler = new MyHandler();
            saxParser.setContentHandler(myHandler);

            saxParser.parse(new File("path_to_your_file.xml"));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.ContentHandler {
    @Override
    public void startDocument() {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) {
        System.out.println("Start of Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length);
        System.out.println("Element Content: " + content);
    }
}