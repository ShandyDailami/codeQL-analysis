import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.CodeSigner;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_20224_XMLParser_A08 extends DefaultHandler {
    private String lastElement;
    private boolean bName;
    private boolean bAge;

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        lastElement = qName;
        if (qName.equals("person")) {
            bName = true;
            bAge = true;
        } else {
            if (bName && qName.equals("name")) {
                bName = false;
            } else if (bName && qName.equals("age")) {
                bAge = false;
            }
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals(lastElement)) {
            if (bName) {
                System.out.println("Name found!");
            } else if (bAge) {
                System.out.println("Age found!");
            }
            lastElement = null;
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();

        InputStream is = new FileInputStream(new File("src/main/resources/sample.xml"));

        MyXMLParser handler = new MyXMLParser();
        sp.parse(is, handler);
    }
}