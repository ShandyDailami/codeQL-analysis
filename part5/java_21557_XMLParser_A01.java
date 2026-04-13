import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_21557_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        DefaultHandler defaultHandler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                System.out.println("Start element: " + qName);
            }

            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                System.out.println("End element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(defaultHandler);
            xmlReader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}