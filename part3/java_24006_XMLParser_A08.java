import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_24006_XMLParser_A08 extends DefaultHandler {

    boolean bElementName = false;
    boolean bElementValue = false;
    
    List<String> elementNames;
    List<String> elementValues;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        bElementName = true;
        bElementValue = false;
        elementNames.add(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElementName = false;
        bElementValue = true;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElementValue) {
            String s = new String(ch, start, length);
            elementValues.add(s);
        }
    }
}