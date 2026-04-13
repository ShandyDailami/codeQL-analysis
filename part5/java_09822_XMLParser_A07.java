import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_09822_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlData = "<note><to>Tove</to><from>Jani</from><message>Vanilla Java XMLParser.</message></note>";
        parse(xmlData);
    }

    public static void parse(String xmlData) {
        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() throws SAXException {
                System.out.println("Start of document");
            }

            public void endDocument() throws SAXException {
                System.out.println("End of document");
            }

            public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) throws SAXException {
                System.out.println("Start of element: " + qualifiedName);
                for (int i = 0; i < atts.getLength(); i++) {
                    System.out.println("Attribute: " + atts.getQualifiedPrefix(i) + "=" + atts.getValue(i));
                }
            }

            public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
                System.out.println("End of element: " + qualifiedName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                String str = new String(ch, start, length);
                System.out.println("Text: " + str);
            }
        };

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(new StringReader(xmlData)));
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        }
    }
}