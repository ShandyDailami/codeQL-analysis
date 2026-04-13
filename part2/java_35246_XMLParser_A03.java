import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_35246_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("src/main/resources/example.xml"), true);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bElementName = false;
    private boolean bElementValue = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("element")) {
            bElementName = true;
            bElementValue = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElementName) {
            bElementName = false;
            System.out.println("Element name: " + new String(ch, start, length));
        }
        if (bElementValue) {
            bElementValue = false;
            System.out.println("Element value: " + new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("element")) {
            bElementName = false;
            bElementValue = false;
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // Do nothing
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // Do nothing
    }
}