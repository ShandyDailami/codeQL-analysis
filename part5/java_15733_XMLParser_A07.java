import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_15733_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            saxParser.setContentHandler(new MyContentHandler());

            saxReader(xmlReader, xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void saxReader(XMLReader xmlReader, File xmlFile) throws SAXException, IOException {
        xmlReader.setContentHandler(new MyContentHandler());
        xmlReader.parse(xmlFile);
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {

    private boolean isTitle = false;
    private boolean isLink = false;
    private boolean isDescription = false;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if ("title".equals(qName)) {
            isTitle = true;
        } else if ("link".equals(qName)) {
            isLink = true;
        } else if ("description".equals(qName)) {
            isDescription = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("title".equals(qName)) {
            isTitle = false;
        } else if ("link".equals(qName)) {
            isLink = false;
        } else if ("description".equals(qName)) {
            isDescription = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTitle) {
            System.out.println("Title: " + new String(ch, start, length));
        } else if (isLink) {
            System.out.println("Link: " + new String(ch, start, length));
        } else if (isDescription) {
            System.out.println("Description: " + new String(ch, start, length));
        }
    }
}