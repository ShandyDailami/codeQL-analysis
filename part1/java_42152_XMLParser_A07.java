import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_42152_XMLParser_A07 {
    private static class MyHandler extends DefaultHandler {
        public void startDocument() {
            System.out.println("Start of document");
        }

        public void endDocument() {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start of element: " + localName);
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + localName);
        }

        public void characters(char[] ch, int start, int length) {
            String str = new String(ch, start, length);
            System.out.println("Characters: " + str);
        }

        public void error(SAXException e) {
            System.out.println("Error: " + e);
        }

        public void fatalError(SAXException e) {
            System.out.println("Fatal error: " + e);
        }
    }

    public static void main(String[] args) {
        File inputFile = new File("example.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}