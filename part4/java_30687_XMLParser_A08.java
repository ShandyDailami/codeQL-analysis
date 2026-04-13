import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXParseException;

public class java_30687_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXParser saxParser = new SAXParser();

            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(saxParser);

            xmlReader.parse("sample.xml");
        } catch (SAXParseException e) {
            System.out.println("Parsing failed at line " + e.getLineNumber() + " : " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Parsing failed : " + e.getMessage());
        }
    }
}

class SAXParser implements javax.xml.parsers.SAXHandler {

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        System.out.println("Ignorable whitespace: " + new String(ch, start, length));
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        System.out.println("Processing instruction: " + target + " " + data);
    }

    @Override
    public void setElementComments(String[] comments) {
        // Not used in this example
    }
}