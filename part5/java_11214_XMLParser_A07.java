import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.ArrayList;
import java.util.List;

public class java_11214_XMLParser_A07 extends DefaultHandler {
    private String currentElement;
    private List<String> elements;

    public java_11214_XMLParser_A07() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.elements.add(this.currentElement);
        this.currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.currentElement != null) {
            this.currentElement += new String(ch, start, length);
        }
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal error: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    public List<String> getElements() {
        return this.elements;
    }
}

public class Main {
    public static void main(String[] args) {
        String xml = "<root><element>1</element><element>2</element><element>3</element></root>";

        MyHandler handler = new MyHandler();
        org.xml.sax.parser.XMLReader parser = org.xml.sax.parser.XMLReaderFactory.createXMLReader();
        parser.setContentHandler(handler);

        try {
            parser.parse(new StringReader(xml));
        } catch (SAXException e) {
            e.printStackTrace();
        }

        List<String> elements = handler.getElements();
        for (String element : elements) {
            System.out.println(element);
        }
    }
}