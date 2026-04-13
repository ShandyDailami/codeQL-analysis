import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11115_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bName = false;
    boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
            System.out.println("Person Name : ");
        } else if (bName) {
            System.out.println("Name : " + localName);
            bName = false;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
            System.out.println("Age : ");
        } else if (bAge) {
            System.out.println("Age : " + attributes.getValue(0));
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
        }
    }
}