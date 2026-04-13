import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_23525_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();

            reader.setContentHandler(new SAXContentHandler(new DefaultHandler() {
                public void startDocument() {
                    System.out.println("Start of document");
                }

                public void endDocument() {
                    System.out.println("End of document");
                }

                public void startElement(String uri, String localName, String qName) {
                    System.out.println("Start of element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) {
                    System.out.println("End of element: " + qName);
                }

                public void characters(char[] ch, int start, int length) {
                    String content = new String(ch, start, length);
                    System.out.println("Character content: " + content);
                }
            }));

            reader.parse("example.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}