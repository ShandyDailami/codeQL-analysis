import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_03892_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        parser.parse(new File("yourfile.xml"), handler);
    }
}

class MyHandler extends DefaultHandler {
    private boolean nameFound = false;
    private boolean idFound = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            nameFound = true;
        } else if (qName.equalsIgnoreCase("id")) {
            idFound = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (nameFound) {
            System.out.println("Name: " + new String(ch, start, length));
            nameFound = false;
        } else if (idFound) {
            System.out.println("ID: " + new String(ch, start, length));
            idFound = false;
        }
    }
}