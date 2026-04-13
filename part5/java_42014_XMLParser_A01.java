import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_42014_XMLParser_A01 extends DefaultHandler {

    private boolean isName = false;
    private boolean isNumber = false;

    public static void main(String[] args) {
        String filePath = "path/to/xml/file.xml";
        File file = new File(filePath);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        try {
            saxParser.parse(file, new BrokenAccessControlXMLParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            isName = true;
        } else if (qName.equalsIgnoreCase("number")) {
            isNumber = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            isName = false;
        } else if (qName.equalsIgnoreCase("number")) {
            isNumber = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            // perform security sensitive operation
            System.out.println("Name: " + new String(ch, start, length));
        } else if (isNumber) {
            // perform security sensitive operation
            System.out.println("Number: " + new String(ch, start, length));
        }
    }
}