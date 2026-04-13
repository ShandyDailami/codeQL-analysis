import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_00483_XMLParser_A07 extends DefaultHandler {
    
    private boolean bName = false;
    private boolean bAge = false;
    private String name = null;
    private int age = 0;
    
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }
    
    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("person".equals(qName)) {
            bName = true;
            bAge = true;
        } else if (bName) {
            name = localName;
            bName = false;
        } else if (bAge) {
            age = Integer.parseInt(localName);
            bAge = false;
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("person".equals(qName)) {
            System.out.println("Name: " + name + ", Age: " + age);
            bName = false;
            bAge = false;
        }
    }
    
    public static void main(String[] args) throws Exception {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();
        
        MyXMLParser myHandler = new MyXMLParser();
        saxParser.parse(Class.forName("org.xml.sax.InputSource").getField("SAX_SOURCE").get(null), myHandler);
    }
}