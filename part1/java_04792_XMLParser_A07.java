import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;

public class java_04792_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new DefaultHandler() {
                public void startDocument() throws SAXException {
                    System.out.println("Start of document");
                }

                public void endDocument() throws SAXException {
                    System.out.println("End of document");
                }

                public void startElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("Start of element " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End of element " + qName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    String content = new String(ch, start, length);
                    System.out.println("Content: " + content);
                }
            });

            reader.parse("src/main/resources/sample.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}