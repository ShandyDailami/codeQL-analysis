import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax. SAXException;

import java.io.File;
import java.io.IOException;

public class java_39404_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        SAXParserHandler handler = new SAXParserHandler();
        try {
            XMLParser parser = new SAXParser(handler);
            parser.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler extends DefaultHandler {

    private StringBuffer buffer = new StringBuffer();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);
        buffer.append("Start of element: ").append(qName).append("\n");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        buffer.append("End of element: ").append(qName).append("\n");
        System.out.println(buffer.toString());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append("Content: ").append(new String(ch, start, length)).append("\n");
    }

    @Override
    public void error(SAXException e) {
        System.err.println("Error: " + e.getMessage());
    }
}