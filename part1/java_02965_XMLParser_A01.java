import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_02965_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();
            parser.setContentHandler(new MyContentHandler());
            parser.setErrorHandler(new MyErrorHandler());
            parser.setEntityResolver(new MyEntityResolver());

            FileInputStream inputStream = new FileInputStream("input.xml");
            parser.parse(inputStream);
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAX Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    public void startDocument() {
        // Security sensitive operation
        System.out.println("Starting document...");
    }

    public void endDocument() {
        // Security sensitive operation
        System.out.println("Ending document...");
    }

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        // Security sensitive operation
        System.out.println("Starting element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) {
        // Security sensitive operation
        System.out.println("Ending element: " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        // Security sensitive operation
        System.out.println("Reading characters: " + new String(ch, start, length));
    }
}

class MyErrorHandler implements org.xml.sax.ErrorHandler {
    public void fatalError(org.xml.sax.SAXException e) {
        // Security sensitive operation
        System.out.println("Fatal error: " + e.getMessage());
    }

    public void error(org.xml.sax.SAXException e) {
        // Security sensitive operation
        System.out.println("Error: " + e.getMessage());
    }

    public void warning(org.xml.sax.SAXWarning warning) {
        // Security sensitive operation
        System.out.println("Warning: " + warning.getMessage());
    }
}

class MyEntityResolver implements org.xml.sax.EntityResolver {
    public InputSource resolveEntity(String url) throws SAXException, IOException {
        // Security sensitive operation
        System.out.println("Resolving external entity: " + url);
        return new InputSource(new StringReader("<entity>Resolved Entity</entity>"));
    }
}