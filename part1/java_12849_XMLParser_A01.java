import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_12849_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(new File("example.xml"), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            System.out.println("Parsing Employee");
            bName = true;
            bAge = true;
        } else if (bName && qName.equalsIgnoreCase("name")) {
            System.out.println("Parsing Employee Name");
        } else if (bName && qName.equalsIgnoreCase("age")) {
            System.out.println("Parsing Employee Age");
            bAge = true;
        } else if (bAge && qName.equalsIgnoreCase("age")) {
            System.out.println("Parsing Employee Age");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            System.out.println("Finished Parsing Employee");
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Employee Name: " + new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Employee Age: " + new String(ch, start, length));
        }
    }
}