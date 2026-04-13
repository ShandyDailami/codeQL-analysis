import java.io.FileInputStream;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class java_34604_XMLParser_A08 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currElement = "";
    private String name = "";
    private int age = 0;

    public static void main(String[] args) {
        try {
            MyXMLParser handler = new MyXMLParser();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            InputStream in = new FileInputStream("sample.xml");
            reader.parse(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("person")) {
            bName = true;
            bAge = true;
            currElement = qName;
        } else if (bName && qName.equals("name")) {
            bName = false;
            name = attributes.getValue(0);
            currElement = qName;
        } else if (bAge && qName.equals("age")) {
            bAge = false;
            age = Integer.parseInt(attributes.getValue(0));
            currElement = qName;
        } else {
            currElement = qName;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currElement.equals("person")) {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
        currElement = "";
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            name += new String(ch, start, length);
        }
    }

    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public void error(SAXParseException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }
}