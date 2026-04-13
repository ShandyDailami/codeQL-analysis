import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_02941_XMLParser_A01 extends DefaultHandler {
    private boolean isPerson = false;
    private boolean isName = false;
    private boolean isAge = false;
    private String personName;
    private int personAge;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("person")) {
            isPerson = true;
        } else if (isPerson) {
            if (qName.equalsIgnoreCase("name")) {
                isName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                isAge = true;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isPerson) {
            personName = new String(ch, start, length);
        } else if (isName) {
            // Do some operation with personName
        } else if (isAge) {
            personAge = Integer.parseInt(new String(ch, start, length));
            // Do some operation with personAge
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("person")) {
            isPerson = false;
        } else if (isPerson && qName.equalsIgnoreCase("name")) {
            isName = false;
        } else if (isPerson && qName.equalsIgnoreCase("age")) {
            isAge = false;
        }
    }
}