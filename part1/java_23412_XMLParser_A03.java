import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class java_23412_XMLParser_A03 extends DefaultHandler {
    private StringBuilder data = new StringBuilder();
    private boolean bName = false;
    private boolean bAge = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("person")) {
            bName = true;
            bAge = true;
        } else if (bName && qName.equals("name")) {
            bName = false;
        } else if (bName && qName.equals("age")) {
            bAge = false;
        }

        data.setLength(0);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            System.out.println(data.toString());
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            data.append("Name: ");
            data.append(new String(ch, start, length));
        } else if (bAge) {
            data.append("Age: ");
            data.append(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyXMLParser());
            saxParser.parse(new File("src/test.xml"), false);
        } catch (ParserConfigurationException | SAXParseException | IOException e) {
            e.printStackTrace();
        }
    }
}