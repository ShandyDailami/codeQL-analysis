import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.security.*;
import java.util.Base64;

public class java_09548_XMLParser_A08 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String strName = null;
    private int iAge = 0;

    public static void main(String[] args) {
        try {
            String xml = "<person><name>Test</name><age>20</age></person>";
            xml = new String(Base64.getDecoder().decode(xml));

            LegacyXMLParser handler = new LegacyXMLParser();
            SAXParserFactory.newInstance().newSAXParser().parse(xml, handler);

            System.out.println("Name: " + handler.getName() + ", Age: " + handler.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("name")) {
            bName = true;
        } else if (qName.equals("age")) {
            bAge = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            strName = new String(ch, start, length);
            bName = false;
        } else if (bAge) {
            iAge = Integer.parseInt(new String(ch, start, length));
            bAge = false;
        }
    }

    public String getName() {
        return strName;
    }

    public int getAge() {
        return iAge;
    }
}