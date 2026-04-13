import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_28171_XMLParser_A08 extends DefaultHandler {
    private String lastTagName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastTagName = qName;
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
        lastTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastTagName != null) {
            System.out.println("Character Data: " + new String(ch, start, length));
            lastTagName = null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(false);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}