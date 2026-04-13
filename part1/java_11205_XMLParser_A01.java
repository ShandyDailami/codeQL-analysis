import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.events.StartElement;
import org.xml.sax.ext.StandardStaxReader;

import java.io.File;
import java.io.IOException;

public class java_11205_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml"); // replace with your xml file path

        try {
            SAXReader saxReader = new SAXReader();
            XMLReader xmlReader = saxReader.getXMLReader();
            xmlReader.setContentHandler(new ContentHandler());
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class SAXReader {
        public XMLReader getXMLReader() {
            return XMLReaderFactory.createXMLReader();
        }
    }

    static class ContentHandler implements org.xml.sax.ContentHandler {
        public void startDocument() {}
        public void endDocument() {}

        public void startElement(StartElement startElement) {
            System.out.println("Start Element: " + startElement.getName().getLocalPart());
        }

        public void endElement(StartElement startElement) {}

        public void characters(char[] chars, int start, int length) {}

        public void fatalError(SAXException e) {}
        public void error(SAXException e) {}
        public void warning(SAXException e) {}
    }
}