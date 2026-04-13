import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXSource;
import java.io.StringReader;
import java.io.IOException;

public class java_26276_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<note>" +
                "<to>Tove</to>" +
                "<from>Jani</from>" +
                "<message>Vi har nådd stiftet.</message>" +
                "</note>";

        try {
            SAXSource saxSource = new SAASource(new StringReader(xml));
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            xmlReader.setContentHandler(new ContentHandlerImpl(xmlReader));
            xmlReader.parse(saxSource);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAASource extends SAXSource {
    public java_26276_XMLParser_A03(StringReader reader) {
        super(reader);
    }

    @Override
    public void setElementContentHandler(ContentHandler contentHandler) throws SAXException {
        throw new SAXException("This method is not allowed");
    }

    @Override
    public void setCharacterDataHandler(ContentHandler contentHandler) throws SAXException {
        throw new SAXException("This method is not allowed");
    }
}

class ContentHandlerImpl implements ContentHandler {
    private final XMLReader xmlReader;

    public java_26276_XMLParser_A03(XMLReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
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
}