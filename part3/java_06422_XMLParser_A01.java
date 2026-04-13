import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_06422_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyHandler myHandler = new MyHandler();

            saxParser.parse(xmlFile, myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {
    private boolean isTitle = true;

    @Override
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) throws SAXException {
        if ("title".equals(qName)) {
            isTitle = true;
        } else if (isTitle) {
            System.out.println("<" + qName + ">");
            isTitle = false;
        } else {
            System.out.println("<" + qName + ">" + attributes.getValue("content"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("title".equals(qName)) {
            isTitle = false;
        } else {
            System.out.println("</" + qName + ">");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // ignore the character data
    }
}