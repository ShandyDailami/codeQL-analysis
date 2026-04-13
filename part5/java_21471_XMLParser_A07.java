import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_21471_XMLParser_A07 extends DefaultHandler {

    private String elementName;
    private boolean isElementName;

    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        elementName = qName;
        isElementName = true;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        isElementName = false;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isElementName) {
            System.out.println(elementName + " : " + new String(ch, start, length));
        }
    }

    public void error(SAXParseException e) {
        System.out.println("Parse error at line " + e.getLineNumber());
    }

    public void fatalError(SAXParseException e) {
        System.out.println("Fatal parse error at line " + e.getLineNumber());
    }

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyXMLParser());
            reader.parse(new File("sample.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}