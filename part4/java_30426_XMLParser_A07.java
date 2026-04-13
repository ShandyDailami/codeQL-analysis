import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMlParser;

import java.io.File;
import java.io.IOException;

public class java_30426_XMLParser_A07 extends DefaultHandler {

    private String currentElement;
    private String currentElementContent;

    public java_30426_XMLParser_A07() throws IOException {
        File xmlFile = new File("src/main/resources/example.xml");
        XMLParser parser = XMLParser.newInstance();
        parser.setContentHandler(this);
        parser.parse(xmlFile);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        currentElementContent = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement.equals("person")) {
            System.out.println("Name: " + currentElementContent);
            System.out.println("Age: " + currentElementContent);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentElementContent = new String(ch, start, length);
    }
}