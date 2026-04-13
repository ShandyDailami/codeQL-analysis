import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class java_18530_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParser parser = org.xml.sax.SAXParserFactory.newInstance().newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(new File("path_to_your_xml_file"), handler);
        } catch (SAXParseException e) {
            System.out.println("Parsing error at line: " + e.getLineNumber());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    private StringBuilder buffer = new StringBuilder();
    private String elementName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementName = localName;
        buffer.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (elementName.equals("element_to_parse")) {
            System.out.println("Parsed element: " + buffer.toString());
        } else {
            System.out.println("Unhandled element: " + elementName);
        }
    }
}