import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import java.io.File;

public class java_37702_XMLParser_A07 extends DefaultHandler {
    public boolean authFailure = false;
    
    public java_37702_XMLParser_A07() {
        super();
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("Start of element " + qName);
        if (qName.equals("authFailure")) {
            authFailure = true;
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End of element " + qName);
        if (qName.equals("authFailure")) {
            authFailure = false;
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyXMLParser myXMLParser = new MyXMLParser();
            XMLReader xmlReader = saxParser.getXMLReader(myXMLParser);
            xmlReader.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}