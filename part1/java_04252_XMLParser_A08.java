import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04252_XMLParser_A08 extends DefaultHandler {
    boolean bName = false;
    boolean bAge = false;
    String qName = "";
    int age = 0;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.qName = qName;
        if (qName.equals("person")) {
            bName = true;
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("name")) {
            bName = false;
        } else if (qName.equals("age")) {
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.print("Name: ");
            System.out.print(new String(ch, start, length));
        } else if (bAge) {
            age = Integer.parseInt(new String(ch, start, length));
        }
    }
}