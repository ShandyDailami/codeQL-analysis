import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_04051_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setEntityResolver(new MyEntityResolver());

            xmlReader.setContentHandler(new MyContentHandler());

            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    @Override
    public void startDocument() {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, org.xml.sax.Attributes attributes) {
        System.out.print("Start element " + qualifiedName + " with ");
        printAttributes(attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) {
        System.out.println("End element " + qualifiedName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    private void printAttributes(org.xml.sax.Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            org.xml.sax.Attributes attribute = attributes.getNamespaceURI(i) == null ? attributes.getQName(i) : attributes.getQName(i);
            System.out.println(attribute.getLocalName() + "=" + attribute.getValue());
        }
    }
}

class MyEntityResolver implements org.xml.sax.EntityResolver {
    @Override
    public void resolveEntity(String arg0, String arg1, org.xml.sax.InputSource arg2) throws SAXException {
        System.out.println("Resolving Entity: " + arg0);
    }
}