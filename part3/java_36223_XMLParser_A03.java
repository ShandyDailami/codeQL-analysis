import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_36223_XMLParser_A03 extends DefaultHandler {
    private static final String SAX_NAMESPACE = "http://xmlns.oracle.com/xsd/";

    public java_36223_XMLParser_A03() {
        super();
    }

    public void parse(String xmlFile) {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(this);
            xr.setNamespaceAware(true);
            xr.setDTDValid(true);
            xr.setErrorHandler(new ErrorHandlerImpl());
            xr.setEntityResolver(new HttpEntityResolverImpl());
            xr.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start element: " + localName);
        // Your security-sensitive operations here
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End element: " + localName);
        // Your security-sensitive operations here
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
        // Your security-sensitive operations here
    }

    public static void main(String[] args) {
        new XmlParser().parse("sample.xml");
    }
}