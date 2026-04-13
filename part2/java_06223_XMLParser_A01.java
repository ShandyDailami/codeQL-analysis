import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLEventReader;
import org.xml.sax.parser.XMLEventWriter;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class java_06223_XMLParser_A01 extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        System.out.println("Content: " + content);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            XMLEventReader xmlReader = SAXParser.getSAXReader().getXMLReader(xmlFile);
            MySAXHandler myHandler = new MySAXHandler();
            xmlReader.setContentHandler(myHandler);

            System.out.println("Parsing...");
            xmlReader.parse(Paths.get("sample.xml").toFile());

            System.out.println("Parsing finished");
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}