import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_19151_XMLParser_A03 extends DefaultHandler {

    private String currentElement;

    public java_19151_XMLParser_A03() {
        System.out.println("Using XML Parser");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentElement.equals("element")) {
            String value = new String(ch, start, length);
            // Do some security sensitive operations here with value.
            System.out.println("Injecting value: " + value);
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {
        // Not doing anything here as it's not required for security sensitive operations.
    }

    @Override
    public void endPrefixMapping(String prefix) {
        // Not doing anything here as it's not required for security sensitive operations.
    }
}