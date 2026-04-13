import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_27071_XMLParser_A03 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String name = null;
    private int age = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        } else if (bName && qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (bName && qName.equalsIgnoreCase("age")) {
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
        } else if (bAge) {
            age = Integer.parseInt(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            // perform some operation with the data here.
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        SAXHelper saxHelper = new SAXHelper();
        saxHelper.setContentHandler(new MyXMLHandler());
        saxHelper.parse("src/main/resources/sample.xml");
    }
}