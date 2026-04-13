import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class java_40620_XMLParser_A08 {
    private static final String XML_FILE_PATH = "src/main/resources/sample.xml";
    private static final String INTEGRITY_FAILURE_TAG = "integrityFailure";
    private static final String INTEGRITY_FAILURE_ATTRIBUTE = "id";

    private Set<String> integrityFailures = new HashSet<>();

    public Set<String> getIntegrityFailures() {
        return integrityFailures;
    }

    public void parse() {
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ContentHandlerImpl());
            reader.parse(XML_FILE_PATH);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private static class ContentHandlerImpl implements ContentHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals(INTEGRITY_FAILURE_TAG)) {
                String id = attributes.getValue(INTEGRITY_FAILURE_ATTRIBUTE);
                integrityFailures.add(id);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // no need to do anything here.
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // no need to do anything here.
        }
    }
}