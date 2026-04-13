import java.security.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_09242_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            XMLParser parser = new XMLParserImpl();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(new InputSource(Files.newInputStream(Paths.get("input.xml"))));
            saxParser.setContentHandler(parser);
            saxParser.parse("input.xml", new SAXSource(new InputSource(Files.newInputStream(Paths.get("input.xml"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLParserImpl implements SAXHandler {
    private boolean isName = false;
    private String name = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("name")) {
            isName = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("name")) {
            isName = false;
        } else if (isName) {
            name += qName + " ";
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            name += new String(ch, start, length);
        }
    }

    public void print() {
        System.out.println(name);
    }
}