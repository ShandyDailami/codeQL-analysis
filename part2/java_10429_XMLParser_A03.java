import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_10429_XMLParser_A03 {
    public static void main(String[] args) {
        String fileName = "example.xml";

        // Parsing using SAX
        SAXParser saxParser = new SAXParser();
        saxParser.parse(fileName);

        // Parsing using DOM
        DOMParser domParser = new DOMParser();
        domParser.parse(fileName);

        // Parsing using DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(fileName));
        XMLParser xmlParser = new XMLParser();
        xmlParser.parse(document);
    }
}

class SAXParser {
    public void parse(String fileName) {
        SAXReader reader = new SAXReader();
        try {
            reader.read(fileName, new SAXHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DOMParser {
    public void parse(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(fileName));
            DOMParser domParser = new DOMParser();
            domParser.parse(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLParser {
    public void parse(Document document) {
        // Your code to parse the XML document here
    }
}

class SAXHandler implements ContentHandler {
    public void startDocument() {
        System.out.println("Start of document");
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of element: " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}