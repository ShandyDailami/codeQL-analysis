import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_19000_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("sample.xml"), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String qName = "";
    private String name = "";
    private String age = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        this.qName = qName;

        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        } else if (bName) {
            if (qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (bAge) {
                if (qName.equalsIgnoreCase("age")) {
                    bAge = false;
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            bName = false;
            bAge = false;
        } else if (bName) {
            if (qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (bAge) {
                if (qName.equalsIgnoreCase("age")) {
                    bAge = false;
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            name = new String(ch, start, length);
        } else if (bAge) {
            age = new String(ch, start, length);
        }
    }
}