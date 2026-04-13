import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_14328_XMLParser_A08 extends DefaultHandler {
    
    private boolean bName = false;
    private boolean bAge = false;
    private String name = null;
    private int age = 0;

    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbFactory.newDocumentBuilder();

            InputStream is = new FileInputStream("sample.xml");
            sp.parse(is, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("Person".equals(localName)) {
            bName = true;
            bAge = true;
        } else if (bName && "Name".equals(localName)) {
            name = attributes.getValue("Name");
        } else if (bAge && "Age".equals(localName)) {
            age = Integer.parseInt(attributes.getValue("Age"));
        } else {
            throw new SAXException("Unexpected element: " + localName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("Person".equals(localName)) {
            if (name == null || age == 0) {
                throw new InvalidParameterException("Name and Age are required for person");
            }
            System.out.println("Name: " + name + ", Age: " + age);
            bName = false;
            bAge = false;
            name = null;
            age = 0;
        } else {
            throw new SAXException("Unexpected element: " + localName);
        }
    }
}