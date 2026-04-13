import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_34861_XMLParser_A08 extends DefaultHandler {
    private String lastElement;
    private StringBuilder content;
    private StringBuilder integrityFailure;

    public java_34861_XMLParser_A08() {
        this.content = new StringBuilder();
        this.integrityFailure = new StringBuilder();
    }

    public StringBuilder getContent() {
        return this.content;
    }

    public StringBuilder getIntegrityFailure() {
        return this.integrityFailure;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.lastElement = qName;
        this.content.append("<").append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            this.content.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
        }
        this.content.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.content.append("</").append(qName).append(">");
        this.lastElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.lastElement != null && this.lastElement.equals(localName)) {
            this.content.append(new String(ch, start, length));
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // Do nothing
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // Do nothing
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        // Do nothing
    }

    @Override
    public void error(SAXException e) throws SAXException {
        // Do nothing
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        // Do nothing
    }
}