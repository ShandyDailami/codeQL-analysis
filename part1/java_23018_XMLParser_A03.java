import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_23018_XMLParser_A03 extends DefaultHandler {

    private String lastTagName;
    private String lastNamespaceURI;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastTagName = qName;
        lastNamespaceURI = uri;
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals(lastTagName)) {
            System.out.println("End of element: " + qName);
        } else {
            System.out.println("End of element: " + lastTagName + " in namespace " + lastNamespaceURI);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        if (content.trim().isEmpty()) {
            return;
        }
        System.out.println("Content: " + content);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("SAXParseException: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal SAXParseException: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("SAXParseException: " + e.getMessage());
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XMLParser());
            parser.parse(new File("sample.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}