import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_27335_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(false);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private String elementContent = "";
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementContent = "";
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementContent = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement.equalsIgnoreCase("employee")) {
            System.out.println("Name: " + elementContent);
            System.out.println("Address: " + elementContent);
        } else {
            if (currentElement.equalsIgnoreCase("name")) {
                System.out.println("Name: " + elementContent);
            } else if (currentElement.equalsIgnoreCase("address")) {
                System.out.println("Address: " + elementContent);
            }
        }
    }
}