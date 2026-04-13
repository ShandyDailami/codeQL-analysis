import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_38568_XMLParser_A03 extends DefaultHandler {

    private List<String> injectionSafeElements;

    public java_38568_XMLParser_A03() {
        this.injectionSafeElements = new ArrayList<>();
    }

    public List<String> getInjectionSafeElements() {
        return this.injectionSafeElements;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String elementContent = "";
        for (int i = 0; i < attributes.getLength(); i++) {
            elementContent += attributes.getQName(i) + "=" + attributes.getValue(i) + " ";
        }
        this.injectionSafeElements.add(elementContent.trim());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Do nothing
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (content.length() > 0) {
            this.injectionSafeElements.add(content);
        }
    }
}