import org.xml.sax.SAXException;
import org.xml.sax.SAXReader;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_18071_XMLParser_A01 extends DefaultHandler {
    boolean bName = false;
    boolean bAge = false;
    String name;
    int age;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            // start of <person> element, enter the inner loop
            bName = true;
            bAge = true;
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            // end of <person> element, exit the inner loop
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
            bName = false;
        } else if (bAge) {
            age = Integer.parseInt(new String(ch, start, length));
            bAge = false;
        }
    }
}

public class XmlParser {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler handler = new MyHandler();
            saxParser.parse(xmlFile, handler);
            System.out.println("Name: " + handler.name + ", Age: " + handler.age);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}