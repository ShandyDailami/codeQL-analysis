import java.io.File;
import java.io.FileInputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLScanner;

public class java_20665_XMLParser_A08 extends DefaultHandler {

    private String currentElement;

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of " + qName);
        currentElement = qName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of " + qName);
        currentElement = "";
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("ElementName")) { // replace ElementName with your element name
            System.out.println(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        try {
            XMLParser parser = XMLParser.newInstance();
            MyXMLHandler handler = new MyXMLHandler();
            parser.setContentHandler(handler);
            parser.setErrorHandler(handler);
            File file = new File("path_to_your_file.xml");
            FileInputStream fis = new FileInputStream(file);
            parser.parse(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}