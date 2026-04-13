import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_22368_XMLParser_A03 extends DefaultHandler {

    private String lastElement;
    private String lastNamespace;

    public java_22368_XMLParser_A03() {
        super();
    }

    public void parse(String filePath) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File(filePath), this);
    }

    @Override
    public void startDocument() {
        System.out.println("Parsing started.");
    }

    @Override
    public void endDocument() {
        System.out.println("Parsing finished.");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) {
        lastElement = qualifiedName;
        lastNamespace = namespaceURI;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName) {
        lastElement = null;
        lastNamespace = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (lastElement != null) {
            String content = new String(ch, start, length);
            System.out.println(lastElement + ": " + content);
        }
    }
}