import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_16886_XMLParser_A07 extends DefaultHandler {
    private boolean bElementName = false;
    private boolean bElementValue = false;
    private String strCurrentElement = "";
    private String strCurrentValue = "";

    public static void main(String[] args) {
        String filename = "example.xml";
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);
            MyXMLHandler myHandler = new MyXMLHandler();
            sp.parse(filename, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) {
        bElementName = true;
        bElementValue = false;
        strCurrentElement = qName;
        strCurrentValue = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        bElementName = false;
        bElementValue = true;
        if (qName.equals(strCurrentElement)) {
            System.out.println("Element Name: " + strCurrentElement +
                    ", Element Value: " + strCurrentValue);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bElementValue) {
            strCurrentValue = new String(ch, start, length);
        }
    }
}