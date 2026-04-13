import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_22663_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("sample.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            MyContentHandler handler = new MyContentHandler();
            reader.setContentHandler(handler);
            reader.parse(inputFile);
            System.out.println("Root element: " + handler.getRootElement());
            System.out.println("Elements: " + handler.getElements());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    private String rootElement;
    private StringBuilder elements;

    public void startDocument() {
        rootElement = "";
        elements = new StringBuilder();
    }

    public void endDocument() {
    }

    public void startElement(String namespaceURI, String localName, String qualifiedName, org.xml.sax.Attributes attributes) throws SAXException {
        rootElement = qualifiedName;
    }

    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        elements.append(qualifiedName).append(" ");
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
    }

    public String getRootElement() {
        return rootElement;
    }

    public String getElements() {
        return elements.toString();
    }
}