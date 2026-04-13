import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.InvalidParameterException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_25832_XMLParser_A03 extends DefaultHandler {

    private String curElement;
    private boolean inElement;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        curElement = qName;
        inElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        inElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inElement) {
            System.out.println(curElement + ": " + new String(ch, start, length));
        }
    }
    
    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        MyXMLParser xhp = new MyXMLParser();
        try {
            InputStream inputStream = new FileInputStream(new File("path/to/your/file.xml"));
            sp.parse(inputStream, xhp);
        } catch (Exception e) {
            throw new InvalidParameterException("Invalid XML file or path specified.");
        }
    }
}