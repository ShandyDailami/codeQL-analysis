import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXParseException;

public class java_39353_XMLParser_A01 {

    public static void main(String[] args) {
        SAXReader saxReader = new SAXReader();

        saxReader.setValidationEnabled(false);

        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();

            SAXParserHandler saxHandler = new SAXParserHandler();

            xmlReader.setContentHandler(saxHandler);

            xmlReader.parse("src/main/resources/example.xml");

        } catch (SAXParseException e) {
            System.out.println("Parsing failed: " + e.getMessage());
       
        } catch (SAXException e) {
            System.out.println("Parse failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}

class SAXParserHandler implements ContentHandler {

    private boolean bTag = false;
    private String sTag = "";

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        bTag = true;
        sTag = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        bTag = false;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bTag) {
            System.out.println(sTag + ": " + new String(ch, start, length));
        }
    }
}