import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;
import org.xml.sax.events.XMLEvent;
import org.xml.sax.events.XMLStructure;
import org.xml.sax.helpers.DefaultHandler;

public class java_32831_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            DefaultHandler handler = new DefaultHandler() {
                public void startDocument() {
                    System.out.println("Start of Document");
                }

                public void endDocument() {
                    System.out.println("End of Document");
                }

                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    System.out.println("Start of Element: " + qName);
                    for (int i = 0; i < attributes.getLength(); i++) {
                        System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
                    }
                }

                public void endElement(String uri, String localName, String qName) {
                    System.out.println("End of Element: " + qName);
                }

                public void characters(char[] ch, int start, int length) {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            };
            reader.setContentHandler(handler);
            reader.parse("src/test.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}