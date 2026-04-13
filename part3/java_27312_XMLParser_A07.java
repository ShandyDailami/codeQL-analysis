import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXParser;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_27312_XMLParser_A07 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String qName = null;
    private int age = -1;

    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        this.qName = qName;
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
        }
        if (bName && qName.equalsIgnoreCase("name"))
            bName = false;
        if (bAge && qName.equalsIgnoreCase("age"))
            bAge = false;
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            String s = new String(ch, start, length);
            System.out.println("Name : " + s);
        } else if (bAge) {
            String s = new String(ch, start, length);
            age = Integer.parseInt(s);
        }
    }
}

public class MySaxParser {
    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        MyHandler mh = new MyHandler();
        sp.parse(new File("test.xml"), mh);
    }
}