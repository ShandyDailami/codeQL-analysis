import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_40009_XMLParser_A08 extends DefaultHandler {
    private Stack<String> elementStack;
    private StringBuilder buffer;
    private boolean integrityFailure;

    public java_40009_XMLParser_A08() {
        elementStack = new Stack<>();
        buffer = new StringBuilder();
        integrityFailure = false;
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new XMLParser());
            parser.parse(new File("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        elementStack.push(qName);
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (integrityFailure) {
            System.out.println("IntegrityFailure: " + qName);
        }
        if (elementStack.pop().equals(qName)) {
            // All good, continue
        } else {
            integrityFailure = true;
            System.out.println("Mismatch in end of " + qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        buffer.append(ch, start, length);
    }

    @Override
    public void error(SAXException e) {
        integrityFailure = true;
        System.out.println("SAXException: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) {
        integrityFailure = true;
        System.out.println("Fatal SAXException: " + e.getMessage());
    }

    @Override
    public void warning(SAXWarning warning) {
        integrityFailure = true;
        System.out.println("Warning: " + warning.getMessage());
    }
}