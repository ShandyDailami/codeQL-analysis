import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.XMLParser;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class java_27712_XMLParser_A03 {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(new File("test.xml"));
        MyHandler handler = new MyHandler();
        saxParser.parse(new File("test.xml"), handler);
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String name;
    private int age;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        } else if (bName && qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (bName && qName.equalsIgnoreCase("age")) {
            bAge = false;
        } else if (bName && qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
        } else if (bAge) {
            age = Integer.parseInt(new String(ch, start, length));
        }
    }
}