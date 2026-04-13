import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_36129_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new XMLHandler());
            parser.parse(new File("input.xml"), XMLHandler.getDefaultHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    private static final String SAX_NAMESPACE_URI = "http://xmlns.oracle.com/oxp/content/simplexml";

    private boolean bTag = false;
    private StringBuilder sb = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        sb.setLength(0);
        if (qName.equalsIgnoreCase("book")) {
            bTag = true;
            sb.append("Book: ");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bTag) {
            bTag = false;
            sb.append("Title: ").append(sb.toString());
            System.out.println(sb.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTag) {
            sb.append(new String(ch, start, length));
        }
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.err.println("Parse Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.err.println("Fatal Error: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.err.println("Warning: " + e.getMessage());
    }
}