import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_15434_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            XMLReader reader = doc.getXMLReader();
            DefaultHandler handler = new DefaultHandler() {
                public void startElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("Encountered an element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End of element: " + qName);
                }
            };
            reader.setContentHandler(handler);
            reader.parse(new File("input.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}