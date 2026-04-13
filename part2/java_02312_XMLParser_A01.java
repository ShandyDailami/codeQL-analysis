import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_02312_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    @Override
    public void startDocument() {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Start person: " + localName);
            bName = true;
            bAge = true;
            return;
        }

        if (bName) {
            System.out.print("Name: " + localName);
            bName = false;
        }

        if (bAge) {
            System.out.println("Age: " + localName);
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("End person: " + localName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName || bAge) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}