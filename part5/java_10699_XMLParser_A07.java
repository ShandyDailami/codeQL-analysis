import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_10699_XMLParser_A07 extends DefaultHandler {

    private boolean isAuthFailure = false;
    private boolean isAuthFailureElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            isAuthFailure = true;
            isAuthFailureElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isAuthFailureElement && qName.equalsIgnoreCase("AuthFailure")) {
            isAuthFailureElement = false;
            System.out.println("AuthFailure element found.");
            isAuthFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isAuthFailureElement) {
            String str = new String(ch, start, length);
            System.out.println("AuthFailure: " + str);
        }
    }

    public static void main(String[] args) {
        MyHandler handler = new MyHandler();
        try {
            org.xml.sax.SAXParserFactory spf = org.xml.sax.SAXParserFactory.newInstance();
            org.xml.sax.SAXParser sp = spf.newSAXParser();
            sp.parse(Class.forName("myfile").getResourceAsStream("authfailure.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}