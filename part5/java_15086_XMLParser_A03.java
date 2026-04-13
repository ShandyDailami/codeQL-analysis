import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_15086_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File("sample.xml"), myHandler);
    }
}

class MyHandler extends DefaultHandler {
    private boolean isName = false;
    private boolean isAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("name")) {
            isName = true;
        } else if (qName.equals("age")) {
            isAge = true;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (isName) {
            System.out.println("Name: " + new String(chars, start, length));
            isName = false;
        } else if (isAge) {
            System.out.println("Age: " + new String(chars, start, length));
            isAge = false;
        }
    }
}