import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_07817_XMLParser_A03 extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of Element : " + qName);

        // Printing element attributes
        System.out.print("Attributes : ");
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(attributes.getQName(i) + "=" + attributes.getValue(i));
            if (i < attributes.getLength() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of Element : " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters : " + new String(ch, start, length));
    }

    public static void main(String[] args) {
        String fileName = "sample.xml";
        XMLLoader loader = new XMLLoader();

        try {
            XMLParser parser = loader.getSAXParser();
            MySAXHandler handler = new MySAXHandler();
            parser.setContentHandler(handler);
            parser.parse(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}