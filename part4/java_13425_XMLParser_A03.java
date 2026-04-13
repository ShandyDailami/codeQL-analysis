import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_13425_XMLParser_A03 {
    private static class MyHandler extends DefaultHandler {
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
            System.out.println("Content: " + content);
        }

        public void fatalError(String msg) throws SAXException {
            System.out.println("Fatal Error: " + msg);
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();

        try {
            XMLReader reader = saxFactory.newSAXParser().getXMLReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);

            reader.parse(new File("sample.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}