import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_13979_XMLParser_A03 extends DefaultHandler {

    private String thisElement = "";
    private boolean bName = false;
    private boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        }
        System.out.print("Start Element : " + qName + " ");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element : " + qName);
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.print("Name: " + new String(ch, start, length));
        }
        if (bAge) {
            System.out.println(" Age: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyXMLParser handler = new MyXMLParser();
        parser.parse(Class.forName("org.xml.sax.InputSource").getField("SAX_SOURCE").get(null), handler);
    }
}