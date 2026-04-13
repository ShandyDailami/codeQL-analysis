import java.io.File;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

public class java_13520_XMLParser_A08 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String strName = null;
    private int iAge = -1;

    public java_13520_XMLParser_A08() {
        super();
    }

    public void startDocument() throws SAXParseException {
        System.out.println("Start document");
    }

    public void endDocument() throws SAXParseException {
        System.out.println("End document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Start element " + qName + " at line " + getLineNumber());
            bName = true;
            bAge = true;
        } else if (bName && qName.equalsIgnoreCase("name")) {
            System.out.println("Start element " + qName + " at line " + getLineNumber());
            bName = false;
        } else if (bName && qName.equalsIgnoreCase("age")) {
            System.out.println("Start element " + qName + " at line " + getLineNumber());
            bAge = false;
        } else if (bAge && qName.equalsIgnoreCase("age")) {
            System.out.println("Start element " + qName + " at line " + getLineNumber());
            iAge = Integer.parseInt(qName);
        } else if (bAge && qName.equalsIgnoreCase("name")) {
            System.out.println("Start element " + qName + " at line " + getLineNumber());
            strName = qName;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("End element " + qName + " at line " + getLineNumber());
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            String str = new String(ch, start, length);
            System.out.println("Name: " + str);
            strName = str;
        } else if (bAge) {
            String str = new String(ch, start, length);
            System.out.println("Age: " + str);
            iAge = Integer.parseInt(str);
        }
    }

    public void fatalError(SAXParseException e) throws SAXParseException {
        System.out.println("Fatal error at line " + e.getLineNumber());
    }

    public void warning(SAXParseException e) throws SAXParseException {
        System.out.println("Warning at line " + e.getLineNumber());
    }

    public int getLineNumber() {
        // you can use the javax.xml.parsers package to obtain the line number
        return -1;
    }

    public static void main(String[] args) throws Exception {
        File xmlFile = new File("sample.xml");
        XMLReader parser = XMLReaderFactory.createXMLReader();
        parser.setContentHandler(new MyXMLParser());
        parser.parse(xmlFile);
    }
}