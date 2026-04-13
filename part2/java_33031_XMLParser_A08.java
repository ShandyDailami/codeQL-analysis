import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_33031_XMLParser_A08 extends DefaultHandler {
    private String currElement;

    public void startElement(String uri, String localName, String qName, Attributes attr) throws SAXException {
        currElement = qName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        currElement = null;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currElement != null) {
            String str = new String(ch, start, length);
            System.out.println(currElement + " : " + str);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(true);
            MyHandler handler = new MyHandler();
            saxParser.parse(new File("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}