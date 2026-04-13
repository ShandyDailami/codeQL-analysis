import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_39479_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Create a handler that does nothing on each node and error
            DefaultHandler handler = new DefaultHandler() {
                public void startDocument() {}
                public void endDocument() {}
                public void startElement(String uri, String localName, String qName) {}
                public void endElement(String uri, String localName, String qName) {}
                public void characters(char[] ch, int start, int length) {}
                public void startPrefixMapping(String prefix, String uri) {}
                public void endPrefixMapping(String prefix, String uri) {}
                public void error(SAXException e) {}
                public void fatalError(SAXException e) {}
                public void warning(SAXException e) {}
            };

            // Parse the XML file
            reader.setContentHandler(handler);
            reader.parse(new InputSource(new StringReader("<data></data>")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}