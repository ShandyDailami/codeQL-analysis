import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_12694_XMLParser_A01 extends DefaultHandler {

    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName) {
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentElement != null) {
            System.out.println("Element: " + currentElement + ", Content: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        MyXMLHandler myHandler = new MyXMLHandler();
        saxParser.parse(new File("sample.xml"), myHandler);
    }
}