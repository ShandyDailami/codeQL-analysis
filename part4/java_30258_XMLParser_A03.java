import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_30258_XMLParser_A03 extends DefaultHandler {
    private String thisElement;
    private boolean bName;
    private boolean bAge;
    private boolean bId;

    public java_30258_XMLParser_A03() {
        bName = false;
        bAge = false;
        bId = false;
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;

        if (thisElement.equals("person")) bName = true;
        else if (thisElement.equals("age")) bAge = true;
        else if (thisElement.equals("id")) bId = true;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";

        if (qName.equals("person")) bName = false;
        else if (qName.equals("age")) bAge = false;
        else if (qName.equals("id")) bId = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) System.out.println("Name: " + new String(ch, start, length));
        else if (bAge) System.out.println("Age: " + new String(ch, start, length));
        else if (bId) System.out.println("ID: " + new String(ch, start, length));
    }
}

public class MyXMLReader {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MySAXHandler());
            reader.parse(xmlFile);
        } catch (SAXParseException e) {
            System.out.println("Parsing error at line " + e.getLineNumber());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}