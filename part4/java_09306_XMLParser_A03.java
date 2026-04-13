import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_09306_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new SAXHandler());
            saxParser.parse(new File("example.xml"), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    boolean bPerson = false;
    String sPersonName = null;
    String sPersonAge = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bPerson = true;
        }
        if (bPerson) {
            if (qName.equalsIgnoreCase("name")) {
                sPersonName = attributes.getValue("name");
            }
            if (qName.equalsIgnoreCase("age")) {
                sPersonAge = attributes.getValue("age");
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bPerson = false;
            System.out.println("Name: " + sPersonName + ", Age: " + sPersonAge);
            sPersonName = null;
            sPersonAge = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bPerson) {
            sPersonAge += new String(ch, start, length);
        }
    }
}