import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class java_37435_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create an instance of the XMLReader
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(new org.xml.sax.InputSource(new File("test.xml")));

            // Create a new instance of the handler
            MyHandler mh = new MyHandler();

            // Set the handler for XML parsing
            sp.setContentHandler(mh);

            // Parse the XML file
            sp.parse("test.xml", mh);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bTitle = false;
    boolean bLink = false;
    StringBuilder title = new StringBuilder();
    StringBuilder link = new StringBuilder();

    public void startDocument() {
        System.out.println("Start Document");
    }

    public void endDocument() {
        System.out.println("End Document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("title")) {
            bTitle = true;
        } else if (qName.equalsIgnoreCase("link")) {
            bLink = true;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (bTitle) {
            bTitle = false;
            title = new StringBuilder();
        } else if (bLink) {
            bLink = false;
            link = new StringBuilder();
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (bTitle) {
            title.append(new String(ch, start, length));
        } else if (bLink) {
            link.append(new String(ch, start, length));
        }
    }

    public void fatalError(String error) {
        System.out.println("Fatal Error: " + error);
    }

    public void warning(String warning) {
        System.out.println("Warning: " + warning);
    }
}