import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_17159_XMLParser_A08 {
    public static void main(String[] args) {
        SAXHandler handler = new SAAXHandler();
        XMLReader reader = null;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File("example.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAAXHandler extends DefaultHandler {
    private int depth = 0;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        printIndentation(depth);
        System.out.println("Start element: " + qName);
        depth++;

        printAttributes(attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        depth--;
        printIndentation(depth);
        System.out.println("End element: " + qName);
    }

    private void printIndentation(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
    }

    private void printAttributes(org.xml.sax.Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
            if (i < attributes.getLength() - 1) {
                System.out.print(", ");
            }
        }
    }
}