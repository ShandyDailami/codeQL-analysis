import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_38554_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName;
    private boolean bAge;

    @Override
    public void startDocument() throws SAXException {
        bName = false;
        bAge = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.print("Name: ");
            bName = false;
        } else if (bAge) {
            System.out.print("Age: ");
            bAge = false;
        }
        System.out.println(new String(ch, start, length));
    }
}