import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_29924_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new File("example.xml"));

            XMLReader reader = doc.getXMLReader();

            DefaultHandler handler = new DefaultHandler() {
                public void startDocument() {
                    System.out.println("Start of document");
                }

                public void endDocument() {
                    System.out.println("End of document");
                }

                public void startElement(String uri, String localName, String qName) {
                    System.out.println("Start element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) {
                    System.out.println("End element: " + qName);
                }

                public void characters(char[] ch, int start, int length) {
                    String content = new String(ch, start, length);
                    System.out.println("Character content: " + content);
                }

                public void fatalError(SAXException e) {
                    System.out.println("Fatal Error: " + e.getMessage());
                }
            };

            reader.setContentHandler(handler);

            reader.parse(new File("example.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}