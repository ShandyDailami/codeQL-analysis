import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_17000_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            String xmlFile = "example.xml"; // replace with your xml file
            File file = new File(xmlFile);
            XMLReader reader = XMLReaderFactory.createXMLReader();

            reader.setContentHandler(new MyContentHandler());
            reader.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler extends MyContentHandlerBase {
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + localName);
        super.startElement(uri, localName, qName, attributes);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + localName);
        super.endElement(uri, localName, qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
        super.characters(ch, start, length);
    }
}

class MyContentHandlerBase implements ContentHandler {
    public void startDocument(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start document");
    }

    public void endDocument(String uri, String localName, String qName) throws SAXException {
        System.out.println("End document");
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Start prefix mapping: " + prefix + ", " + uri);
    }

    public void endPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("End prefix mapping: " + prefix + ", " + uri);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        System.out.println("Ignorable whitespace: " + new String(ch, start, length));
    }

    public void processingInstruction(String target, String data) throws SAXException {
        System.out.println("Processing instruction: " + target + ", " + data);
    }

    public void setElementComments(boolean comments) throws SAXException {
        System.out.println("Set element comments: " + comments);
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + localName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + localName);
    }

    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal error: " + error);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}