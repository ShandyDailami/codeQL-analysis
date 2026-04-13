import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_41078_XMLParser_A01 extends DefaultHandler {

    private boolean bAccessControlEnabled = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("access")) {
            if (attributes.getValue("enabled").equalsIgnoreCase("true")) {
                bAccessControlEnabled = true;
            } else {
                // Broken Access Control detected
                if (bAccessControlEnabled) {
                    System.out.println("Broken Access Control detected!");
                }
            }
        }
    }

    public static void main(String[] args) {
        SAXHelper helper = new SAXHelper();
        CustomXMLParser handler = new CustomXMLParser();
        helper.setContentHandler(handler);
        try {
            helper.parse("src/example.xml"); // replace with your file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}