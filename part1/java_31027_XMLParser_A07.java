import java.io.File;
import java.util.Iterator;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSLTProcessor;
import org.xml.sax.parser.Xerces2SAXParser;

public class java_31027_XMLParser_A07 extends DefaultHandler {

    private String lastElement;

    public java_31027_XMLParser_A07() {
        super();
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        lastElement = qName;
        System.out.println("Start Element: " + qName);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        lastElement = null;
        System.out.println("End Element: " + qName);
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (lastElement != null) {
            System.out.println("Character Data: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        MyXMLParser handler = new MyXMLParser();
        XMLReader reader = null;
        try {
            reader = XMLReader.newInstance();
            reader.setContentHandler(handler);
            reader.parse(new File("test.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}