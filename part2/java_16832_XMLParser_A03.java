import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_16832_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (SAXParser saxParser = saxParserFactory.newSAXParser();
             XMLReader xmlReader = XMLReaderFactory.createXMLReader()) {

            saxParser.setContentHandler(new MyContentHandler());
            xmlReader.setContentHandler(new MyContentHandler());

            xmlReader.parse(new File("src/main/resources/sample.xml"));
            saxParser.parse(new File("src/main/resources/sample.xml"));

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler extends javax.xml.parsers.SAXHandler {
    private boolean isElement = false;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        isElement = true;
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        isElement = false;
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isElement) {
            System.out.println("Element Value: "
                   + new String(ch, start, length));
        }
    }
}