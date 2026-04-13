import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;

public class java_05369_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // the path to your xml file
        parseXml(xmlFile);
    }

    private static void parseXml(String xmlFile) {
        // create a new XMLReader
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new EntityResolver() {
                public Object resolveEntity(String publicId, String systemId)
                        throws SAXException, IOException {
                    // return null if the systemId is not known.
                    return null;
                }
            });

            // create a new handler
            DefaultHandler handler = new DefaultHandler() {
                public void startDocument() {
                    System.out.println("Start document");
                }

                public void endDocument() {
                    System.out.println("End document");
                }

                public void startElement(String uri, String localName, String qName,
                        Attributes attributes) throws SAXException {
                    System.out.println("Start element: " + qName);
                }

                public void endElement(String uri, String localName, String qName)
                        throws SAXException {
                    System.out.println("End element: " + qName);
                }

                public void characters(char[] ch, int start, int length)
                        throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            };

            // parse the xml file
            reader.setContentHandler(handler);
            reader.parse(new File(xmlFile));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}