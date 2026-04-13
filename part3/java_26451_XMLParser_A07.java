import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_26451_XMLParser_A07 extends DefaultHandler {
    private List<String> namespaces;

    public java_26451_XMLParser_A07() {
        namespaces = new ArrayList<>();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of the document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of the document");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        namespaces.add(namespaceURI);
        System.out.println("Start of element: " + qualifiedName);
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        System.out.println("End of element: " + qualifiedName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        System.out.println("Characters: " + content);
    }

    @Override
    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal error: " + error);
    }

    @Override
    public void error(SAXException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    public static void main(String[] args) {
        SAXParser parser = new SAXParser();
        // replace this with your XML content
        String xmlContent = "<root><name>John</name><occupation>Engineer</occupation></root>";
        org.xml.sax.InputSource is = new org.xml.sax.InputSource(new StringReader(xmlContent));
        org.xml.sax.SAXParser saxParser = org.xml.sax.SAXParserFactory.newInstance().newSAXParser(is);
        saxParser.parse(is, parser);
    }
}