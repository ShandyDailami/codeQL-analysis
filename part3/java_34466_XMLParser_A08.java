import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_34466_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null);

            MyHandler handler = new MyHandler();
            saxParser.parse(XmlParser.class.getResourceAsStream("/sample.xml"), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bElementName = false;
    String elementName = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        bElementName = true;
        elementName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElementName = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElementName) {
            System.out.println("Element Name: " + elementName + ", Text: " + new String(ch, start, length));
        }
    }
}