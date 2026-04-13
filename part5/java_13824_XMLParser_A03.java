import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_13824_XMLParser_A03 extends DefaultHandler {

    boolean bInElement = false;
    String thisElement = null;

    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        bInElement = true;
        thisElement = qName;
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        bInElement = false;
        thisElement = null;
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bInElement) {
            String str = new String(ch, start, length);
            if (thisElement.equals("security")) {
                // Security-sensitive operation here
                System.out.println("Found security sensitive operation: " + str);
            }
        }
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        // Instantiate SAXParser
        SAXParserFactory saxpf = SAXParserFactory.newInstance();
        SAXParser saxp = saxpf.newSAXParser(true);

        // Parse the XML document
        MySAXParser sh = new MySAXParser();
        saxp.parse(new InputSource(new StringReader("<root><security>Injection</security></root>")), sh);
    }
}