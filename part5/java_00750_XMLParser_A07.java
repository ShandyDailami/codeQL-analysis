import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_00750_XMLParser_A07 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private boolean bCountry = false;
    private String strName = null;
    private int iAge = 0;
    private String strCountry = null;
    
    public static void main(String[] args) {
        String xml = "<person>\n" +
                "  <name>John</name>\n" +
                "  <age>25</age>\n" +
                "  <country>USA</country>\n" +
                "</person>";
        new MyXMLParser().parse(xml);
    }
    
    public void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new InputSource(new StringReader(xml)), this);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("name")) bName = true;
        if (qName.equals("age")) bAge = true;
        if (qName.equals("country")) bCountry = true;
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("name")) bName = false;
        if (qName.equals("age")) bAge = false;
        if (qName.equals("country")) bCountry = false;
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            strName = new String(ch, start, length);
        } else if (bAge) {
            iAge = Integer.parseInt(new String(ch, start, length));
        } else if (bCountry) {
            strCountry = new String(ch, start, length);
        }
    }
    
    @Override
    public void endDocument() throws SAXException {
        if (bName && bAge && bCountry) {
            System.out.println("Name: " + strName);
            System.out.println("Age: " + iAge);
            System.out.println("Country: " + strCountry);
        } else {
            System.out.println("Invalid data!");
        }
    }
}