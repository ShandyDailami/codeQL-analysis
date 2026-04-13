import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.Xerces2SAXParser;
import org.xml.sax.xmlreader.SAXXMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_12202_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/example.xml");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new Xerces2SAXParser());
            MyHandler myHandler = new MyHandler();

            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(myHandler);

            saxParser.setProperty("http:catalog_namespace_prefixes", "cns");
            saxParser.setProperty("http:xml_namespace_prefixes", "ns");

            xmlReader.parse(xmlFile.getAbsolutePath());
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private boolean bCountry = false;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            return;
        }

        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        } else if (qName.equalsIgnoreCase("country")) {
            bCountry = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            return;
        }

        if (qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = false;
        } else if (qName.equalsIgnoreCase("country")) {
            bCountry = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            System.out.print("Name: ");
            System.out.println(new String(ch, start, length));
        } else if (bAge) {
            System.out.print("Age: ");
            System.out.println(new String(ch, start, length));
        } else if (bCountry) {
            System.out.print("Country: ");
            System.out.println(new String(ch, start, length));
        }
    }
}