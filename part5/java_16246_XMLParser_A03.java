import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_16246_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(true);

        MyHandler handler = new MyHandler();
        parser.parse(new File("src/main/resources/data.xml"), handler);
    }
}

class MyHandler extends DefaultHandler {
    private boolean isName;
    private boolean isAge;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            isName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            isAge = true;
        }
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            isName = false;
        } else if (qName.equalsIgnoreCase("age")) {
            isAge = false;
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (isAge) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}