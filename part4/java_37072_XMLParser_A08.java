import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_37072_XMLParser_A08 extends DefaultHandler {

    private List<String> integrityFailureStrings = new ArrayList<>();

    private boolean integrityFailureFlag = false;

    private StringBuilder currentElementContent = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("integrityFailure")) {
            integrityFailureFlag = true;
        }
        currentElementContent.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (integrityFailureFlag) {
            currentElementContent.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("integrityFailure")) {
            integrityFailureStrings.add(currentElementContent.toString());
            integrityFailureFlag = false;
        }
    }

    public static void main(String[] args) {
        UniqueVanillaXmlParser parser = new UniqueVanillaXmlParser();
        // Here you will provide your XML data to be parsed.
        // parser.parse(new InputSource(new StringReader("your XML data here")));
    }

}