// Start of the Java code

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.ext.DefaultHandler2;
import java.io.File;
import java.io.IOException;

public class java_39379_XMLParser_A08 extends DefaultHandler2 {

    private int depth;
    private StringBuilder text;
    private boolean integrityFailure;

    public java_39379_XMLParser_A08() {
        depth = 0;
        text = new StringBuilder();
        integrityFailure = false;
    }

    public void parse(String filename) throws IOException, SAXException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(this);
        reader.parse(new File(filename));
        if (integrityFailure) {
            throw new SAXException("Integrity failure in XML file");
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            org.xml.sax.Attributes attributes) throws SAXException {
        depth++;
        text.append(localName);
        checkIntegrity();
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        depth--;
        text.append(" ");
        checkIntegrity();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(new String(ch, start, length));
        checkIntegrity();
    }

    private void checkIntegrity() {
        if (depth < 0 || text.length() == 0 || text.charAt(0) != '<' || text.charAt(text.length()-1) != '>') {
            integrityFailure = true;
        }
    }

}

// End of the Java code