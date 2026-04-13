import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_31490_XMLParser_A07 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = "";

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if(qName.equals("person")) {
            bName = true;
            bAge = true;
        } else {
            if(bName) {
                if(currentElement.equals("name")) {
                    bName = false;
                }
            }
            if(bAge) {
                if(currentElement.equals("age")) {
                    bAge = false;
                }
            }
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            saxParser.parse(new File("src/test.xml"), new MySAXHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}