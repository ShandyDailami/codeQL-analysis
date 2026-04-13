import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_17120_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("src/main/resources/data.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private boolean bAddress = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("person".equals(qName)) {
            bName = true;
            bAge = true;
            bAddress = true;
        } else if (bName) {
            if ("name".equals(localName)) {
                bName = false;
            }
        } else if (bAge) {
            if ("age".equals(localName)) {
                bAge = false;
            }
        } else if (bAddress) {
            if ("address".equals(localName)) {
                bAddress = false;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("person".equals(qName)) {
            bName = false;
            bAge = false;
            bAddress = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
        } else if (bAddress) {
            System.out.println("Address: " + new String(ch, start, length));
        }
    }
}