import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_36825_XMLParser_A01 extends DefaultHandler {

    private String lastElement;
    private String lastNamespaceURI;
    private boolean isStartElement;

    public java_36825_XMLParser_A01() throws IOException {
        // Load XML document into memory
        XMLLoader loader = new XMLLoader(new File("path_to_your_xml_file.xml"));
        loader.setContentHandler(this);
        loader.parse(new File("path_to_your_xml_file.xml"));
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) throws SAXException {
        // Handle namespaceURI and localName here
        lastElement = qName;
        lastNamespaceURI = namespaceURI;
        isStartElement = true;
    }

    @Override
    public void endElement(String namespaceURI, String localName) throws SAXException {
        // Handle end of an element here
        lastElement = localName;
        lastNamespaceURI = namespaceURI;
        isStartElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Handle character data here
        if (isStartElement) {
            System.out.println(lastNamespaceURI + " " + lastElement + ": " + new String(ch, start, length));
        }
    }
}