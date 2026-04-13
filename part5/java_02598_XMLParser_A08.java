import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_02598_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            SAXSource saxSource = new SAXSource(new FileReader(xmlFile));
            saxParser.parse(saxSource, myHandler);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean elementName = false;
    private boolean elementValue = false;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("element")) {
            elementName = true;
            elementValue = false;
        } else {
            if (elementName) {
                System.out.println("Element name: " + qName);
                elementName = false;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementName) {
            System.out.println("Element value: " + new String(ch, start, length));
            elementValue = true;
        }
    }
}