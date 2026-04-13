import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_34662_XMLParser_A08 {

    private class MyHandler extends DefaultHandler {
        public void startDocument() {
            System.out.println("Start Document");
        }

        public void endDocument() {
            System.out.println("End Document");
        }

        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start Element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element: " + qName);
        }

        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            System.out.println("Content: " + content);
        }

        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }

    public void parseXML(String fileName) {
        try {
            File inputFile = new File(fileName);
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new MyHandler());
            xmlReader.parse(inputFile);
        } catch (IOException e) {
            System.out.println("Error Reading File: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAX Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        parser.parseXML("sample.xml");
    }
}