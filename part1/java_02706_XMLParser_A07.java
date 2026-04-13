import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_02706_XMLParser_A07 extends DefaultHandler {

    private String lastElement;
    private String lastNamespace;
    private String lastPrefix;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElement = "";
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        lastPrefix = prefix;
        lastNamespace = uri;
    }

    public void endPrefixMapping(String prefix) throws SAXException {
        lastPrefix = "";
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement.equals("AuthFailure")) {
            String authFailureData = new String(ch, start, length);
            System.out.println("AuthFailure: " + authFailureData);
        }
    }

    public static void main(String[] args) {
        String fileName = "test.xml";
        File xmlFile = new File(fileName);

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new org.xml.sax.InputSource(new FileInputStream(xmlFile)));
            MyXMLParser handler = new MyXMLParser();
            saxParser.setContentHandler(handler);

            saxParser.parse(new File(fileName), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }
}