import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLStreamException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class java_06362_XMLParser_A03 extends DefaultHandler {
    private String lastElement;
    private boolean bName;
    private boolean bAge;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        System.out.println("Start Element: " + qName);
        lastElement = qName;
        bName = true;
        bAge = false;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
        lastElement = qName;
        if(qName.equals("name")) bName = false;
        if(qName.equals("age")) bAge = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bName){
            System.out.println("Name: " + new String(ch, start, length));
        }
        if(bAge){
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(new InputStreamReader(new FileInputStream(new File("src/main/resources/sample.xml")), "UTF-8");
            saxParser.setProperty("http://xml.org/sax/features", "http://xml.org/sax/features/namespace-prefixes");
            saxParser.setProperty("http://xml.org/sax/features", "http://xml.org/sax/features/rng-supported");
            MyXMLSAXHandler myHandler = new MyXMLSAXHandler();
            saxParser.parse(new InputStreamReader(new FileInputStream(new File("src/main/resources/sample.xml")), "UTF-8"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}