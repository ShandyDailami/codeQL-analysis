import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.xmlreader.SAXReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_38615_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        MyHandler mh = new MyHandler();
        try {
            SAXReader reader = new SAXReader();
            reader.setContentHandler(mh);
            sp.parse(new File("example.xml"), mh);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean name = false;
    private boolean age = false;

    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            name = true;
        } else if (qName.equalsIgnoreCase("age")) {
            age = true;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (name) {
            System.out.println("Name: " + new String(ch, start, length));
            name = false;
        } else if (age) {
            System.out.println("Age: " + new String(ch, start, length));
            age = false;
        }
    }
}