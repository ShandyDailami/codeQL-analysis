import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class java_23506_XMLParser_A01 {

    public static void main(String[] args) {
        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() {
                System.out.println("Start of document");
            }

            public void endDocument() {
                System.out.println("End of document");
            }

            public void startElement(String uri, String localName, String qName,
                    Attributes attributes) throws SAXException {
                System.out.print("Start of element " + qName);
            }

            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                System.out.println("End of element " + qName);
            }

            public void characters(char[] ch, int start, int length)
                    throws SAXException {
                String contents = new String(ch, start, length);
                System.out.println("Contents: " + contents);
            }

            public void error(SAXParseException e) {
                System.out.println("SAXParseException: " + e.getMessage());
            }

            public void fatalError(SAXParseException e) {
                System.out.println("Fatal Error: " + e.getMessage());
            }

            public void warning(SAXParseException e) {
                System.out.println("Warning: " + e.getMessage());
            }
        };

        XMLReader xmlReader = null;
        try {
            File xmlFile = new File("sample.xml");
            xmlReader = SAXReader.newInstance().build(xmlFile);
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new SAXSource(xmlReader));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}