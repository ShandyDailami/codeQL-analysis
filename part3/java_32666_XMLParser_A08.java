import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;

import java.io.File;
import java.io.IOException;

public class java_32666_XMLParser_A08 extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of Element : " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of Element : " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        System.out.println("Data in Element: " + data);
    }

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParser parser = XMLParser.newInstance();

        try {
            parser.setContentHandler(new MyXMLHandler());
            parser.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}