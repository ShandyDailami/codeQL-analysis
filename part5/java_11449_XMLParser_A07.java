import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11449_XMLParser_A07 {

    public static void main(String[] args) {
        String fileName = "example.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        saxParser.parse(new File(fileName), handler);
    }
}

class MyHandler extends DefaultHandler {
    private boolean isNamespace = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("namespace")) {
            isNamespace = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("namespace")) {
            isNamespace = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isNamespace) {
            System.out.println(new String(ch, start, length));
        }
    }
}