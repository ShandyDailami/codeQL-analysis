import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.handler.SAXHandler;

public class java_09853_XMLParser_A07 extends SAXHandler {
    private boolean authFailure = false;
    private int faultLine = 0;

    @Override
    public void startElement(String uri, String localName, String qName,
            org.xml.sax.Attributes attributes) throws SAXException {
        if (localName.equals("AuthFailure")) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (localName.equals("AuthFailure")) {
            if (!authFailure) {
                throw new SAXException("AuthFailure not found!");
            }
        } else {
            authFailure = false;
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri)
            throws SAXException {
        // No prefix mapping here
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // No prefix mapping here
    }

    public static void main(String[] args) {
        String xml = "<root>\n" +
                "<Message>Hello World!</Message>\n" +
                "<AuthFailure>Auth failure</AuthFailure>\n" +
                "</root>";

        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new MySAXHandler());
        try {
            reader.parse("data.xml", new StringReader(xml));
        } catch (SAXException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}