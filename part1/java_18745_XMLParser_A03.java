import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_18745_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);

            XmlHandler xh = new XmlHandler();
            sp.parse(XmlSAXParser.class.getResourceAsStream("sample.xml"), xh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Start element: " + qName);
            bName = true;
            bAge = true;
        } else if (bName) {
            System.out.print("Name: " + localName);
            bName = false;
        } else if (bAge) {
            System.out.println(", Age: " + localName);
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("End element: " + qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName || bAge) {
            System.out.print(new String(ch, start, length));
        }
    }
}