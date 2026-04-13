import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import java.io.File;
import java.io.IOException;

public class java_17963_XMLParser_A08 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String strName = null;
    private int iAge = 0;

    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Person")) {
            bName = true;
            bAge = true;
        } else if (bName && qName.equals("Name")) {
            bName = false;
        } else if (bName && qName.equals("Age")) {
            bAge = false;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Person")) {
            System.out.println("Name: " + strName + ", Age: " + iAge);
            bName = false;
            bAge = false;
            strName = null;
            iAge = 0;
        } else if (bName && qName.equals("Name")) {
            strName = localName;
        } else if (bAge && qName.equals("Age")) {
            iAge = Integer.parseInt(localName);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            strName = new String(ch, start, length);
        } else if (bAge) {
            iAge = Integer.parseInt(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        String file = "example.xml";
        File fXmlFile = new File(file);
        XMLParser xmlParser = XMLParser.newInstance();

        try {
            xmlParser.setContentHandler(new MyXMLHandler());
            xmlParser.parse(fXmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}