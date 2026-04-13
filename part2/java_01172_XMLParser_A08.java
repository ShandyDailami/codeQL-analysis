import java.util.List;
import java.util.stream.Collectors;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLScanner;

public class java_01172_XMLParser_A08 extends DefaultHandler {
    private List<String> tags;
    private StringBuffer buffer;
    private boolean integrityCheck;

    public java_01172_XMLParser_A08(boolean integrityCheck) {
        this.integrityCheck = integrityCheck;
        tags = new ArrayList<>();
        buffer = new StringBuffer();
    }

    public void parse(InputStream is) {
        XMLReader xr = XMLParser.newSAXParser(is).getSAXParser();
        xr.setContentHandler(this);
        xr.parse(new InputSource(new StringReader("")));
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);
        tags.add(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (integrityCheck) {
            // add integrity check code here
            if (!checkIntegrity(tags)) {
                throw new SAXException("Integrity failure detected");
            }
        }
        tags.remove(tags.size() - 1);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    private boolean checkIntegrity(List<String> tags) {
        // Implement your own integrity check logic here
        // This is just a placeholder.
        return tags.stream().allMatch(tag -> tag.equals("tag"));
    }
}