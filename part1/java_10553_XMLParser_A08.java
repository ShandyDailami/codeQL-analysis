import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_10553_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);

            MyHandler handler = new MyHandler();
            parser.parse(XMLParser.class.getResourceAsStream("sample.xml"), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bElement = false;
    String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        bElement = true;
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            System.out.println(currentElement + " = " + new String(ch, start, length));
            bElement = false;
        }
    }
}