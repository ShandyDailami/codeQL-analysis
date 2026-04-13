import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.BasicHandler;

public class java_26350_XMLParser_A08 {

    public static void main(String[] args) {
        BasicHandler handler = new BasicHandler() {

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + localName);
            }

            @Override
            public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
                System.out.println("Start element: " + localName);
           
                if (localName.equals("element")) {
                    // you can add more security-sensitive operations here
                    // e.g. checking for presence of a certain attribute,
                    // or using the attribute value to perform a cryptographic operation
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse("sample.xml"); // replace with your XML file
        } catch (Exception e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }
}