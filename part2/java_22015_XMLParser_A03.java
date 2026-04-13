import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;
import org.xml.sax.helpers.XMLReaderFactoryImpl;

import java.io.File;
import java.io.IOException;

public class java_22015_XMLParser_A03 {

    public static void parseFile(String filename) {
        File xmlFile = new File(filename);
        SAXHandler handler = new SAXHandler();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile.toURI().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parseFile("sample.xml");
    }
}

class SAXHandler extends DefaultHandler {

    private boolean parsingTitle = false;
    private boolean parsingLink = false;
    private String currentElement;

    @Override
    public void startDocument() {
        System.out.println("Parsing XML document");
    }

    @Override
    public void endDocument() {
        System.out.println("Finished parsing XML document");
    }

    @Override
    public void startElement(String uri, String localName, String qName) {
        if (qName.equals("title")) {
            parsingTitle = true;
        } else if (qName.equals("link")) {
            parsingLink = true;
        }
        currentElement = qName;
    }

    @Override
    public java_22015_XMLParser_A03(String uri, String localName, String qName) {
        if (qName.equals("title")) {
            parsingTitle = false;
        } else if (qName.equals("link")) {
            parsingLink = false;
        }
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (parsingTitle) {
            System.out.println("Title: " + new String(ch, start, length));
        } else if (parsingLink) {
            System.out.println("Link: " + new String(ch, start, length));
        }
    }
}