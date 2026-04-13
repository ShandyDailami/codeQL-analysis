import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_39875_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            parseXML("example.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String filename) throws IOException, SAXParseException {
        File file = new File(filename);
        SAXReader saxReader = new SAXReader();
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();

        MyHandler handler = new MyHandler();
        xmlReader.setContentHandler(handler);
        xmlReader.parse(file);
    }

    private static class MyHandler extends DefaultHandler {
        private boolean tagName = false;
        private String currentTag;

        @Override
        public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attributes)
                throws SAXException {
            tagName = true;
            currentTag = qualifiedName;
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
            tagName = false;
            currentTag = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (tagName) {
                System.out.println(currentTag + ": " + new String(ch, start, length));
            }
        }
    }
}