import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_20401_XMLParser_A07 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(inputFile);
            System.out.println("Parsing complete.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler {
        public void startDocument() {
            System.out.println("Start of document");
        }
        public void endDocument() {
            System.out.println("End of document");
        }
        public void startElement(String namespaceURI, String localName, String qualifiedName, org.xml.sax.Attributes atts) {
            System.out.println("Start of " + qualifiedName);
        }
        public void endElement(String namespaceURI, String localName, String qualifiedName) {
            System.out.println("End of " + qualifiedName);
        }
        public void characters(char[] ch, int start, int length) {
            String text = new String(ch, start, length);
            System.out.println("Characters: " + text);
        }
    }
}