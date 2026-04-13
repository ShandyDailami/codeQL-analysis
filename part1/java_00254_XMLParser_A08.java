import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class java_00254_XMLParser_A08 extends DefaultHandler {

    boolean bElement = false;
    String currentElement = "";

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        bElement = true;
        currentElement = qName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            System.out.println(currentElement + " : " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        try {
            URL url = new File("sample.xml").toURI().toURL();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}