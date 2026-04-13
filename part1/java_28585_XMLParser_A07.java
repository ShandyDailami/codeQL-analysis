import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_28585_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();

            XMLReader xr = sp.getXMLReader();

            MyHandler mh = new MyHandler();
            xr.setContentHandler(mh);
            xr.parse("data.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements ContentHandler {
    private boolean inElement = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        inElement = true;
        System.out.println("Start of element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        inElement = false;
        System.out.println("End of element: " + qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inElement) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}