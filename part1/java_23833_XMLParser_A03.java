import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

public class java_23833_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";

        XMLReader reader = null;
        BasicHandler handler = new BasicHandler() {
            public void startElement(String namespaceURI, String localName, String qualifiedName, String[] atts) {
                System.out.println("Start element: " + qualifiedName);
            }
            public void endElement(String namespaceURI, String localName, String qualifiedName) {
                System.out.println("End element: " + qualifiedName);
            }
            public void characters(String chars, int start, int length) {
                System.out.println("Characters: " + chars);
            }
        };

        try {
            reader = XMLReaderFactory.createXMLReader(handler);
        } catch (SAXException e) {
            e.printStackTrace();
        }

        try {
            reader.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}