import java.io.File;
import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;

public class java_19913_XMLParser_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file.xml");
        FileInputStream fis = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            fis = new FileInputStream(file);
            doc = builder.parse(fis);
        } catch (Exception e) {
            System.out.println("Parsing failed: " + e.getMessage());
            return;
        }

        XMLReader reader = doc.getXMLReader();
        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() {
            }

            public void endDocument() {
            }

            public void startElement(String uri, String localName, String qName) {
            }

            public void endElement(String uri, String localName, String qName) {
            }

            public void characters(char[] ch, int start, int length) {
                String content = new String(ch, start, length);
                if (content.trim().equals("authFailure")) {
                    throw new AuthFailureException("Authentication failed");
                }
            }
        };

        try {
            reader.setContentHandler(handler);
            reader.parse(new InputSource(new StringReader(doc.getDocumentElement().getFirstChild().getNodeValue())));
        } catch (AuthFailureException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Parsing failed: " + e.getMessage());
        }
    }
}