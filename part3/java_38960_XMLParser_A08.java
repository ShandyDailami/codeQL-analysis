import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_38960_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new XmlHandler());
            saxParser.parse(xmlFile, new XmlHandler());
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String currElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currElement = qName;

        if (qName.equals("name")) {
            bName = true;
        } else if (qName.equals("age")) {
            bAge = true;
        } else {
            System.out.println("Start element: " + qName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("name")) {
            bName = false;
        } else if (qName.equals("age")) {
            bAge = false;
        } else {
            System.out.println("End element: " + qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Character: " + new String(ch, start, length));
        }
    }
}